package com.worksap.wh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.worksap.wh.service.PrometheusService;

@Controller
public class PrometheusController implements PrometheusControllerIF {

	@Autowired
	PrometheusService prometheusService;

	@RequestMapping("/aspect1")
	@ResponseBody
	public String prometheusLogic1() {
		return prometheusService.prometheusLogic();
	}

	@RequestMapping("/aspect")
	@ResponseBody
	public String prometheusLogic() {
		return null;
	}

	@Override
	public String noMappingMethod() {
		System.out.println("Controller no mapping method");
		return null;
	}
}
