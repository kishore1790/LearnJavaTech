package org.poc.LearnJavaTech.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.poc.LearnJavaTech.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.poc.LearnJavaTech.dao.UserDAO;
import org.poc.LearnJavaTech.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	UserDAO userDao;
	
	@RequestMapping(value= {"/","/login"})
	public ModelAndView login() {
		
//		List<Employee> userList=userDao.getUsers();
		ModelAndView mav=new ModelAndView("login");
		mav.addObject("user", new User());
		mav.addObject("greeting","Hi!! Thank you for Login to this page:)");
		return mav;
	}
	
	@RequestMapping(value="/loginValidate", method=RequestMethod.GET)
	 public ModelAndView registerGet() {
	    ModelAndView mav = new ModelAndView();
	    Employee employee = new Employee();
	    mav.addObject("name", employee);
	    mav.setViewName("/loginValidate");
	    return mav;
	  }
	
	
	@RequestMapping(value = "/loginValidate", method = RequestMethod.POST)
	public ModelAndView loginValidate(@ModelAttribute("user") User user) {
		List<User> userList = userDao.getUsers();
		for (User userObj : userList) {
			if (userObj.getName().equalsIgnoreCase(user.getName())
					&& userObj.getPassword().equals(user.getPassword())) {
				return new ModelAndView("home");
			}
		}
		Map<String,String> errMap=new HashMap<>();
		errMap.put("message","Sign In Error");
		ModelAndView mav=new ModelAndView("error");
		mav.addObject("err", errMap);
		return mav;
	}
	
}
