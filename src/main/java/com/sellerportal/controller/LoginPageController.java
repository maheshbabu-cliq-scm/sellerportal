package com.sellerportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sellerportal.ism.SessionVariablesBean;
import com.sellerportal.service.UserLoginActionBean;

@Controller
public class LoginPageController {
	
	@Autowired
	UserLoginActionBean ulab;
	
	@GetMapping("/")
	public String displayLoginPage()
	{
		return "userLogin";
	}
	
	@PostMapping("/submitForm")
	public void submit()
	{
		ulab.userLogin_submitAction();
	}

}
