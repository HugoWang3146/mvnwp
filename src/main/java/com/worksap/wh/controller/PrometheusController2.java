package com.worksap.wh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.worksap.wh.service.PrometheusService;

@Controller
public class PrometheusController2 {

	private final PrometheusControllerIF controller;

	@Autowired
	public PrometheusController2(PrometheusControllerIF controller) {
		System.out.println(controller.getClass());
		this.controller = controller;
	}

	@RequestMapping("/2aspect")
	public String foo() {
		controller.noMappingMethod();
		return null;
	}

}
