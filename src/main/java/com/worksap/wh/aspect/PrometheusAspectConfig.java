package com.worksap.wh.aspect;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.worksap.wh.aspect.PrometheusProfileAspect;
import com.worksap.wh.aspect.PrometheusUsageAspect;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
//@EnableAspectJAutoProxy
@Conditional(PrometheusEnabledCondition.class)
@PropertySource({ "classpath:prometheus.properties" })
public class PrometheusAspectConfig {

	@Bean
	@Conditional(PorfileEnableCondition.class)
	public PrometheusProfileAspect getPrometheusAspect() {
		return new PrometheusProfileAspect();
	}

	@Bean
	@Conditional(UsageEnableCondition.class)
	public PrometheusUsageAspect getPrometheusUsageAspect() {
		return new PrometheusUsageAspect();
	}

}

class PrometheusEnabledCondition implements Condition {
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Properties prop = new Properties();
		try {
			prop.load(PrometheusEnabledCondition.class.getClassLoader().getResourceAsStream("prometheus.properties"));
			return Boolean.valueOf(prop.getProperty("aspect.prometheus.enabled"));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		// Environment ev = context.getEnvironment();
		// System.out.println(ev.getProperty("aspect.prometheus.enabled"));
		// return null != ev &&
		// "true".equals(ev.getProperty("aspect.prometheus.enabled"));
	}
}

class PorfileEnableCondition implements Condition {
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment ev = context.getEnvironment();
		boolean flag = (null != ev && null != ev.getProperty("aspect.prometheus.profile.enabled"))
				? Boolean.valueOf(ev.getProperty("aspect.prometheus.profile.enabled"))
				: true;
		return flag;
	}
}

class UsageEnableCondition implements Condition {
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment ev = context.getEnvironment();
		boolean flag = (null != ev && null != ev.getProperty("aspect.prometheus.usage.enabled"))
				? Boolean.valueOf(ev.getProperty("aspect.prometheus.usage.enabled"))
				: true;
		return flag;
	}
}
