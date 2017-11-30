package com.worksap.wh.service;

import org.springframework.stereotype.Service;

@Service
public class PrometheusService {
	public String prometheusLogic(String sParam, int iParam) {
		System.out.println("prometheus  logic service string/int");
		somePrivateMethod();
		return "prometheus";
	}

	public String prometheusLogic() {
		System.out.println("prometheus  logic service no params");
		somePrivateMethod();
		return "prometheus";
	}

//	public String prometheusLogic2(String sParam, int iParam) {
//		System.out.println("prometheus  logic service 2 ");
//		somePrivateMethod();
//		return "prometheus";
//	}

	private void somePrivateMethod() {
		System.out.println("private method");
	}
}
