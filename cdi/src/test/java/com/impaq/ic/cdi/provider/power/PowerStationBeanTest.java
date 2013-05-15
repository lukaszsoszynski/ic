package com.impaq.ic.cdi.provider.power;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;

public class PowerStationBeanTest extends AbstractCdiTest {

	private PowerStationService powerStationService;

	@Before
	public void setUp() throws Exception {
		powerStationService = setUpWeld(PowerStationService.class);
	}

	@After
	public void ternDown() {
		shutDownWeld();
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
