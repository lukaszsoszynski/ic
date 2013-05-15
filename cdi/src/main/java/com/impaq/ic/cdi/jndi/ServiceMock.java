package com.impaq.ic.cdi.jndi;

public class ServiceMock implements Service {

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

}
