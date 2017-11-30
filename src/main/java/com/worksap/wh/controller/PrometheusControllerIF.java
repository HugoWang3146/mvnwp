package com.worksap.wh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public interface PrometheusControllerIF {
	@RequestMapping("/aspect")
	@ResponseBody
	public String prometheusLogic();

	@RequestMapping("/aspect1")
	@ResponseBody
	public String prometheusLogic1();

	public String noMappingMethod();
}
