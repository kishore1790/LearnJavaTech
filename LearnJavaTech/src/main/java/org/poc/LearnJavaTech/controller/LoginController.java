package org.poc.LearnJavaTech.controller;

import javax.validation.Valid;

import org.poc.LearnJavaTech.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/loginValidate", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("employee")Employee employee, 
      BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        if("Kishore".equalsIgnoreCase(employee.getName()) && "password".equalsIgnoreCase(employee.getPassword()))
        {
        	return "success";
        }
        return "error";
    }
}
