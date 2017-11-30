package com.worksap.wh.controller;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	String message = "Welcome to Spring MVC!";

	@RequestMapping("/")
	public ModelAndView index() {
		Path filePath = Paths.get("application.properties");
		System.out.println(filePath.toString());
		return new ModelAndView("index");
	}

	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
}
