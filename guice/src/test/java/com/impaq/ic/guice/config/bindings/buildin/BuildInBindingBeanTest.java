package com.impaq.ic.guice.config.bindings.buildin;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.impaq.ic.guice.config.ConfigModule;

public class BuildInBindingBeanTest {

	private BuiltInBindingBean builtInBindingBean;

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new ConfigModule());
		builtInBindingBean = injector.getInstance(BuiltInBindingBean.class);
	}

	@Test
	public void testGetLoggerName() {
		assertThat(builtInBindingBean.getLoggerName()).isEqualTo(
				BuiltInBindingBean.class.getCanonicalName());
	}

	@Test
	public void testIsInit() {
		assertThat(builtInBindingBean.isInit()).isTrue();
	}

}
