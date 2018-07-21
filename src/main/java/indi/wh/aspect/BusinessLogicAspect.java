package indi.wh.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BusinessLogicAspect {
	@Before("execution(* *.doBusinessLogic(..))")  
    public void before(JoinPoint joinPoint){  
        System.out.println("before");  
    } 
	
	@After("execution(* *.doBusinessLogic(..))")  
    public void after(JoinPoint joinPoint){  
        System.out.println("after");  
    } 
}
