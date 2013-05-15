package com.impaq.ic.cdi.app.counter;

import javax.interceptor.InvocationContext;

public class InvocationCounterInterceptor {

	private InvocationCounterServins invocationCounterServins;

	public Object manageTransaction(InvocationContext ctx) throws Exception {
		invocationCounterServins.increment();
		return ctx.proceed();
	}
}
