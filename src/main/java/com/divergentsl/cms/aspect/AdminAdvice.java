package com.divergentsl.cms.aspect;

import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
@Component
public class AdminAdvice {
	
	@Before("execution(* com.divergentsl.cms.*.*(..))")
	public void beforeMethod() {
	}
	
	@AfterReturning("execution(* com.divergentsl.cms.dao.*.*(..))")
	public void afterReturning() {
	
	}
	

}
