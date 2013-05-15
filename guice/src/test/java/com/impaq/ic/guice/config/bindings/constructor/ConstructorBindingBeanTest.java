package com.impaq.ic.guice.config.bindings.constructor;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.impaq.ic.guice.config.ConfigModule;

public class ConstructorBindingBeanTest {

	private ConstructorBindingService constructorBindingService;

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new ConfigModule());
		constructorBindingService = injector
				.getInstance(ConstructorBindingService.class);
	}

	@Test
	public void test() {
		assertThat(constructorBindingService.isCorrectInit()).isTrue();
	}

}
