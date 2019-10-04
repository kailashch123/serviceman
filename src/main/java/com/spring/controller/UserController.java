package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.User;
import com.spring.service.iface.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/getAllUsers", method=RequestMethod.GET)
	public ModelAndView getAll(ModelAndView mv) {
		List<User> users = userService.findAll();
		mv.addObject("users", users);
		mv.setViewName("listUser");
		return mv;
		
	}
	
	@RequestMapping(value = "/getUserById/{userId}", method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable("userId") int userId, ModelAndView mv) {
		User user = userService.findById(userId);
		mv.addObject("user", user);
		mv.setViewName("userDetail");
		return mv;
		
	}
	
	@RequestMapping(value = "/listUsers", method=RequestMethod.GET)
	public ModelAndView listUsers(ModelAndView mv) {
		mv.addObject("user", new User());
		mv.setViewName("newUser");
		return mv;
		
	}
}
