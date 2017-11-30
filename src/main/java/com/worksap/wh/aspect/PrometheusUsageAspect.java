package com.worksap.wh.aspect;

import java.util.Date;
import java.util.regex.Pattern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.Histogram;
import io.prometheus.client.Summary;

@Aspect
public class PrometheusUsageAspect {

	private static final Counter SEARCH_REQUEST_COUNTER = Counter.build()
			.name("dicing_search_front_search_request_times_total").help("Total search request amount").register();

	private static final Gauge SEARCH_REQUEST_GAUGE = Gauge.build().name("dicing_search_front_search_request")
			.help("Current search request amount").register();

	private static final Histogram HISTOGRAM = Histogram.build().name("requests_latency_seconds")
			.help("Request latency in seconds.").register();

	// dice
	private static final Summary DICE_COMPONENT_SUMMARY = Summary.build()
			.name("dicing_search_front_dice_component_times_summary").help("The usage of dice component").register();

	// suggest
	private static final Summary SUGGEST_COMPONENT_SUMMARY = Summary.build()
			.name("dicing_search_front_suggest_component_times_summary").help("The usage of suggest component")
			.register();

	// date
	private static final Summary DATE_UI_COMPONENT_SUMMARY = Summary.build()
			.name("dicing_search_front_date_ui_component_times_summary").help("The usage of date ui component")
			.register();

	// type
	private static final Summary TYPE_UI_COMPONENT_SUMMARY = Summary.build()
			.name("dicing_search_front_type_ui_component_times_summary").help("The usage of type ui component")
			.register();

	private static final Pattern TYPE_KEYWORD_PATTERN = Pattern.compile(".*date\\:.*");

	private static final Pattern DATE_KEYWORD_PATTERN = Pattern.compile(".*(date\\:|before\\:|after\\:).*");

	@Around("execution(* com.worksap.wh.controller.PrometheusController.prometheusLogic())")
	public Object aroundSomePrivateMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around before prometheusLogic");
		Object[] args = pjp.getArgs();
		if (args.length > 0) {
			String arg1 = String.valueOf(args[0]);
			System.out.println(args.toString());
			System.out.println(arg1);
		}
		Object retVal = pjp.proceed();
		System.out.println("around after prometheusLogic");
		return retVal;
	}

}
