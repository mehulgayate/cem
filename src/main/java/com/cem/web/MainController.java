package com.cem.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cem.entity.User;
import com.cem.entity.support.Repository;
import com.evalua.entity.support.DataStoreManager;

@Controller
public class MainController {
	
	
	@Resource
	private Repository repository;
	
	@Resource
	private DataStoreManager dataStoreManager;
	
	@RequestMapping("/")
	public ModelAndView showHome(HttpServletRequest request,HttpSession session){
	
		User user=(User) session.getAttribute("user");
		if(user==null){
			new ModelAndView("redirect:/login");
		}
		
		return new ModelAndView("index");
	}
	
	@RequestMapping("/login")
	public ModelAndView showLogin(HttpServletRequest request){
		
		return new ModelAndView("login");
	}
	
	@RequestMapping("/authenticate")
	public ModelAndView authenticate(HttpServletRequest request,HttpSession session){
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		User user=repository.findUserByEmail(email);
		
		
		if(user!=null && user.getPassword().equals(password)){
			session.setAttribute("user", user);			
			return new ModelAndView("redirect:/");
		}
		
		return new ModelAndView("wrong-authentication");
		
	}

}
