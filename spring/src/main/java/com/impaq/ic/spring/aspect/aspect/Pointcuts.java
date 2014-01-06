package com.impaq.ic.spring.aspect.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

	//problem with javaconfig (spring 3.2.2) when com.impaq.ic.spring.aspect.AspectConfiguration in "aspect class path"
	@Pointcut("execution(* com.impaq.ic.spring.aspect.service.impl..*(..))")
	public void everyServiceImpl(){}
	
	@Pointcut("@target(com.impaq.ic.spring.aspect.aspect.Validable)")
	public void annotatedWithValid(){}
}
