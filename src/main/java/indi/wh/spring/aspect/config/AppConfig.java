package indi.wh.spring.aspect.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
/*
 @EnableAspectJAutoProxy(proxyTargetClass = true)
 if proxyTargetClass = true, explictly declare the target class is to be proxied, 
 rather than the target class' interfaces.
 */
public class AppConfig {

}
