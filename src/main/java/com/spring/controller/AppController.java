package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView getIndexPage(ModelAndView mv) {
		mv.setViewName("home");
		return mv;
	}
}
