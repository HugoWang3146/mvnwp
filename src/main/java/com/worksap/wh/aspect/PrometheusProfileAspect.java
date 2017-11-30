package com.worksap.wh.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import io.prometheus.client.Counter;
import io.prometheus.client.Summary;

@Aspect
public class PrometheusProfileAspect {

	private static final Summary SEARCH_SERVICE_LATENCY_SUMMARY = Summary.build()
			.name("dicing_search_front_search_latency_seconds_summary").help("The latency of search service")
			.register();

	private static final Summary SEARCH_RENDER_LATENCY_SUMMARY = Summary.build()
			.name("dicing_search_front_search_render_latency_seconds_summary")
			.help("The latency of search service's render").register();

	private static final Summary SUGGEST_LATENCY_SUMMARY = Summary.build()
			.name("dicing_search_front_suggest_latency_seconds_summary").help("The latency of suggest service")
			.register();

//	@Before("execution(* com.worksap.wh.service.PrometheusService.prometheusLogic())")
//	public void before(JoinPoint joinPoint) throws Throwable {
//		System.out.println("Inside RunBeforeExecution.before() method...");
//		System.out.println("inserted before : " + joinPoint.getSignature().getName());
//	}
//
//	@After("execution(* com.worksap.wh.service.PrometheusService.prometheusLogic())")
//	public void after(JoinPoint joinPoint) throws Throwable {
//		System.out.println("Inside RunBeforeExecution.after() method...");
//		System.out.println("inserted after : " + joinPoint.getSignature().getName());
//	}

}
