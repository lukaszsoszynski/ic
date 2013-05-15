package com.impaq.ic.spring.interceptor.interceptor;

import javax.inject.Inject;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogInterceptor {

	@Inject
	private LogBean logBean;

	public LogInterceptor() {
	}

	@Before("execution(* com.impaq.ic.spring.interceptor.listgenerator.RockListGeneratorBean.*(..))")
	public void invoke(JoinPoint joinPoint) throws Throwable {

		String name = joinPoint.getSignature().getName();
		logBean.append("Before method invocation: " + name);
	}

}
