package org.poc.LearnJavaTech.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.poc.LearnJavaTech.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private static final Logger logger =
			LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	EmployeeDAO employeeDao;
	
	@RequestMapping(value= {"/","/login"})
	public ModelAndView login() {
		logger.info("login Method Invoked");
//		List<Employee> userList=userDao.getUsers();
		ModelAndView mav=new ModelAndView("login");
		mav.addObject("user", new User());
		mav.addObject("greeting","Hi!! Thank you for Login to this page:)");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/loginValidate", method = RequestMethod.POST)
	public ModelAndView loginValidate(@ModelAttribute("user") User user) {
		List<User> userList = userDao.getUsers();
		Map<String,String> map=new HashMap<>();
		ModelAndView mav=null;
		
		List<Employee> employeeList=employeeDao.getEmployeeList();
		for (User userObj : userList) {
			if (userObj.getName().equalsIgnoreCase(user.getName())
					&& userObj.getPassword().equals(user.getPassword())) {
				mav=new ModelAndView("home");
				mav.addObject("user", userObj);
				mav.addObject("employeeList", employeeList);
				mav.addObject("empSize", employeeList.size());
				return mav;
			}
		}
		mav=new ModelAndView("error");
		map.put("message","Sign In Error");
		mav.addObject("err", map);
		return mav;
	}
	
}
