package com.impaq.ic.cdi.jndi;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceConsumer {

	private final Service service;

	public ServiceConsumer() throws NamingException {
		InitialContext initialContext = new InitialContext();
		this.service = (Service) initialContext.lookup(Service.NAME);
		if (service == null) {
			throw new IllegalStateException("Cannot find "
					+ Service.class.getCanonicalName());
		}
	}

	public String saySth() {
		return service.sayHello("ServiceConsumer");
	}

}
