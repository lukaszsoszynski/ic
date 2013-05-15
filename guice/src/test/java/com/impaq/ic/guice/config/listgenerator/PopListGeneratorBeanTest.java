package com.impaq.ic.guice.config.listgenerator;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.impaq.ic.guice.config.ConfigModule;

public class PopListGeneratorBeanTest {

	private PopListGeneratorBean popListGeneratorBean;

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new ConfigModule());
		popListGeneratorBean = injector.getInstance(PopListGeneratorBean.class);
	}

	@Test
	public void test() {
		Assertions.assertThat(popListGeneratorBean.createPlayList()).isEqualTo(
				"Pop0 Pop1 Pop2");
	}

}
