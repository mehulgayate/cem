package com.cem.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cem.entity.Product;
import com.cem.entity.Question;
import com.cem.entity.Question.Status;
import com.cem.entity.User;
import com.cem.entity.support.Repository;
import com.cem.web.support.QuestionService;
import com.evalua.entity.support.DataStoreManager;

@Controller
public class QuestionController {

	@Resource
	private Repository repository;

	@Resource
	private DataStoreManager dataStoreManager;

	@Resource
	private QuestionService questionService;


	@RequestMapping("/questions")
	public ModelAndView showPosts(HttpSession session){
		User user=(User) session.getAttribute("user");
		if(user==null){
			return new ModelAndView("redirect:/login");
		}


		List<Question> questions=repository.listQuestionsByUser(user);
		return new ModelAndView("user/questions").addObject("questions",questions);
	}

	@RequestMapping("/search")
	public ModelAndView search(HttpSession session, @RequestParam(required = false) String query){
		User user=(User) session.getAttribute("user");
		ModelAndView mv= new ModelAndView("user/search");
		if(user==null){
			return new ModelAndView("redirect:/login");
		}

		if(StringUtils.isNotBlank(query)){
			List<Product> products=repository.listProductByName(query);

			for (Product product : products) {
				product.setSearchCount(product.getSearchCount()+1);
				dataStoreManager.save(product);
				for (Product product2 : product.getComparables()) {
					product2.setSearchCount(product2.getSearchCount()+1);
					dataStoreManager.save(product2);
				}
			}

			mv.addObject("products", products);
			mv.addObject("searched", true);
			mv.addObject("query", query);
		}

		return mv;
	}



	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session){	

		session.invalidate();
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping("/new-question")
	public ModelAndView addPost(@ModelAttribute Question question, HttpSession session,HttpServletRequest request){
		User user=(User) session.getAttribute("user");
		if(user==null){
			return new ModelAndView("redirect:/login");
		}		

		Question existedQuestion = repository.findQuestionByQuestionAndUser(question.getQuestion(),user);
		if(existedQuestion!=null){
			return new ModelAndView("redirect:/questions");
		}

		long questionHit = 1; 
		List<Question> questions = repository.listQuestionByQuestionAndUser(question.getQuestion());
		for (Question question2 : questions) {
			question2.setQuestionHit(question2.getQuestionHit()+1);
			questionHit = question2.getQuestionHit();
			dataStoreManager.save(question2);

		}
		question.setQuestionHit(questionHit);
		questionService.processQuestion(question);

		if(question.getStatus()!=null && question.getStatus()==Status.ACTIVE){
			question.setUser(user);		
			dataStoreManager.save(question);
		}

		return new ModelAndView("redirect:/questions");

	}
	
	@RequestMapping("/product-review")
	public ModelAndView productReview(HttpSession session,@RequestParam Long productId,@RequestParam String review, String searchString) throws IOException {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return new ModelAndView("redirect:/login");
		}
		
		Product product = repository.findProductById(productId);
		if(StringUtils.isNotBlank(review)){
			product.getReviews().add(review);
			dataStoreManager.save(product);
		}
		
		return new ModelAndView("redirect:/search?query="+searchString);
	}

}
