package com.impaq.ic.guice.interceptor.interceptor;

import javax.inject.Inject;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogInterceptor implements MethodInterceptor {

	@Inject
	private LogBean logBean;

	public LogInterceptor() {
	}

	@Override
	public Object invoke(MethodInvocation ctx) throws Throwable {
		String name = ctx.getMethod().getName();
		logBean.append("Before method invocation: " + name);
		return ctx.proceed();
	}

}
