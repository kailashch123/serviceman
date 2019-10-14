package com.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.User;
import com.spring.service.iface.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "userlist";
	}

	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "user";
	}

	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "user";
		}
		userService.saveUser(user);
		return "redirect:/userlist";
	}

	@RequestMapping(value = "/edit-user-{userId}", method = RequestMethod.GET)
	public String editUser(@PathVariable int userId, ModelMap model) {
		User user = userService.findById(userId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "user";
	}

	@RequestMapping(value = "/edit-user-{userId}", method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result, ModelMap model, @PathVariable int userId) {
		if (result.hasErrors()) {
			return "user";
		}
		userService.update(user);
		return "redirect:/userlist";
	}

	@RequestMapping(value = "/delete-user-{userId}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable int userId) {
		userService.deleteUserById(userId);
		return "redirect:/userlist";
	}

}
