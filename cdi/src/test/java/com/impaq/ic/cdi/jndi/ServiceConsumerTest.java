package com.impaq.ic.cdi.jndi;

import static org.junit.Assert.assertEquals;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ServiceConsumerTest {

	private ServiceConsumer consumer;

	@BeforeClass
	public static void beforeClass() {
		System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
				MockInitialContextFactory.class.getCanonicalName());
	}

	@Before
	public void setUp() throws NamingException {
		consumer = new ServiceConsumer();
	}

	@Test
	public void test() {
		assertEquals("Hello ServiceConsumer", consumer.saySth());
	}

}
