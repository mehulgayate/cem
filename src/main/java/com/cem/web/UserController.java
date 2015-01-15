package com.cem.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cem.entity.User;
import com.cem.entity.support.Repository;
import com.evalua.entity.support.DataStoreManager;

@Controller
public class UserController {

	@Resource
	private Repository repository;
	
	@Resource
	private DataStoreManager dataStoreManager;
	
	@RequestMapping("/login")
	public ModelAndView showLogin(){
		return new ModelAndView("login/login");
	}
	
	@RequestMapping("/authenticate")
	public ModelAndView authenticate(@RequestParam String email, @RequestParam String password, HttpSession session){
		
		User user=repository.findUserByEmail(email);
		
		if(user!=null && user.getPassword().equals(password)){
			session.setAttribute("user", user);
			return new ModelAndView("redirect:/");		
			
		}else{
			return new ModelAndView("login/loging-failure");
		}
	}
	
	@RequestMapping("/signup")
	public ModelAndView showRegister(){
		return new ModelAndView("login/signup");
	}
	
	@RequestMapping("/signup-complete")
	public ModelAndView signupComplete(){
		return new ModelAndView("login/signup-complete");
	}
	
	@RequestMapping("/edit-user")
	public ModelAndView editUser(){
		return new ModelAndView("user/edit-user");
	}
	
	@RequestMapping("/save-user")
	public ModelAndView saveUser(@ModelAttribute User user, HttpSession session){
		
		User existingUser= repository.findUserByEmail(user.getEmail());
		
		String[] ignoreProperties = {"id", "email", "password"};
		
		BeanUtils.copyProperties(user, existingUser, ignoreProperties);
		dataStoreManager.save(existingUser);
		
		session.setAttribute("user", existingUser);
		return new ModelAndView("redirect:/posts");
	}
	
	@RequestMapping("/add-user")
	public ModelAndView addUser(@ModelAttribute User user){
		
		User foundUser=repository.findUserByEmail(user.getEmail());
		
		if(foundUser==null){
			dataStoreManager.save(user);
		}
		
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping("/")
	public ModelAndView showHome(HttpServletRequest request, HttpSession session){
		
		User user=(User) session.getAttribute("user");
		if(user==null){
			return new ModelAndView("redirect:/login");
		}
		return new ModelAndView("user/index");
	}
	
	/*@RequestMapping("/file-view")
	public String viewFile(@RequestParam Long id, HttpServletResponse response) throws IOException{
		FileAttachment fileAttachment= repository.findFileAttachmentById(id);
		
		response.setContentType(fileAttachment.getMimeType());
        response.setHeader("Content-disposition", "inline; filename="+ fileAttachment.getName());
        fileAttachment.writeAttachmentTo(response.getOutputStream());
        response.getOutputStream().close();
        
        return null;
		
	}*/
	
}
