package com.impaq.ic.cdi.decorator.power;

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
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void test() {
		String music = powerStationService.listenToMusic();
		System.out.println(music);
		assertThat(music).contains("Rock0");
		assertThat(music).contains("Rock1");
		assertThat(music).contains("Rock2");
	}

}
