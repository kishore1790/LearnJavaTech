package org.poc.LearnJavaTech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	
	@RequestMapping(value= {"/","/login"})
	public ModelAndView login() {
		
		ModelAndView mav=new ModelAndView("login");
		mav.addObject("greeting","Hi!! Thank you for Login to this page:)");
		return mav;
		
	}
	
	@RequestMapping(value="/test")
	public ModelAndView loginValidate(@RequestParam(value="greeting" ,required=false)String  greeting) {
		ModelAndView mav=new ModelAndView("login");
		if(greeting==null)
			mav.addObject("greeting","Default Login");
		
		mav.addObject("greeting",greeting);
		return mav;
	}
}
