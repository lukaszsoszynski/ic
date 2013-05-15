package com.impaq.ic.spring.provider.power;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PowerStationBeanTest {

	private AnnotationConfigApplicationContext applicationContext;
	private PowerStationService powerStationService;

	@Before
	public void setUp() throws Exception {
		applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("com.impaq.ic.spring.provider");
		applicationContext.refresh();

		powerStationService = applicationContext
				.getBean(PowerStationService.class);
	}

	@After
	public void tearDown() throws Exception {
		applicationContext.close();
	}

	@Test
	public void testMusic() {
		assertThat(powerStationService.listenToMusic()).endsWith(
				"Rock0 Rock1 Rock2");
	}

	@Ignore
	@Test
	public void testDifferentInstance() {
		String music1 = powerStationService.listenToMusic();
		String music2 = powerStationService.listenToMusic();

		System.out.print("Music " + music1 + " another music: " + music2);
		assertThat(music1).isNotEqualTo(music2);
	}

}
