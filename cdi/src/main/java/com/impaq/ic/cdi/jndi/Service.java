package com.impaq.ic.cdi.jndi;

public interface Service {

	/**
	 * Service name
	 */
	String NAME = "com.impaq.example.service";

	/**
	 * Service method
	 * 
	 * @param name
	 * @return
	 */
	String sayHello(String name);

}
