package com.impaq.ic.guice.config.power;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.impaq.ic.guice.config.ConfigModule;

public class PowerStationBeanTest {

	private PowerStationService powerStationService;

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new ConfigModule());
		powerStationService = injector.getInstance(PowerStationService.class);
	}

	@Test
	public void testListenToMusic() {
		Assertions.assertThat(powerStationService.listenToMusic()).endsWith(
				"Rock0 Rock1 Rock2 Pop0 Pop1 Pop2");
	}

}
