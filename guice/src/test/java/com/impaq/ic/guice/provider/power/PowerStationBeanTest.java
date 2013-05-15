package com.impaq.ic.guice.provider.power;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.impaq.ic.guice.provider.ProviderModule;

public class PowerStationBeanTest {

	private Injector injector;
	private PowerStationService powerStationService;

	@Before
	public void setUp() throws Exception {
		injector = Guice.createInjector(new ProviderModule());
		powerStationService = injector.getInstance(PowerStationService.class);
	}

	@Test
	public void testMusic() {
		assertThat(powerStationService.listenToMusic()).endsWith(
				"Rock0 Rock1 Rock2");
	}

	@Test
	public void testDifferentInstance() {
		String music1 = powerStationService.listenToMusic();
		String music2 = powerStationService.listenToMusic();

		System.out.println("Music " + music1 + " another music: " + music2);
		assertThat(music1).isNotEqualTo(music2);
	}

}
