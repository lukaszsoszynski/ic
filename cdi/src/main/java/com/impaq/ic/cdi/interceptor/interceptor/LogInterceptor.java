package com.impaq.ic.cdi.interceptor.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Loggable
@Interceptor
public class LogInterceptor {

	private final LogBean logBean;

	@Inject
	public LogInterceptor(LogBean logBean) {
		this.logBean = logBean;
	}

	@AroundInvoke
	public Object manageTransaction(InvocationContext ctx) throws Exception {
		String name = ctx.getMethod().getName();
		logBean.append("Before method invocation: " + name);
		return ctx.proceed();
	}

}
