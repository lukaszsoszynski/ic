package com.impaq.ic.guice.config.bindings.justintime;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.impaq.ic.guice.config.ConfigModule;

public class JustInTimeBindingBeanTest {

	private JustInTimeBindingBean justInTimeBindingBean;

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new ConfigModule());
		justInTimeBindingBean = injector
				.getInstance(JustInTimeBindingBean.class);
	}

	@Test
	public void test() {
		assertThat(justInTimeBindingBean.isInit()).isTrue();
	}

}
