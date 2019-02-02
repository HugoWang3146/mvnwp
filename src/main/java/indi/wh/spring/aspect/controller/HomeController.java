package indi.wh.spring.aspect.controller;

import indi.wh.spring.aspect.service.BusinessLogicServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	private final static String MESSAGE = "Welcome to Spring MVC!";

	@Autowired
	private BusinessLogicServiceIF bl;
	
	@RequestMapping("/")
	public ModelAndView index() {
		bl.doBusinessLogic();
		System.out.println(bl.getClass());
		return new ModelAndView("index");
	}
	
	@RequestMapping("/controllerMethod")
	public ModelAndView controllerMethod() {
		return new ModelAndView("index");
	}

	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("message", MESSAGE);
		mv.addObject("name", name);
		return mv;
	}
}
