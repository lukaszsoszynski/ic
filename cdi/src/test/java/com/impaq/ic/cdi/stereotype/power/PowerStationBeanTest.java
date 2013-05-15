package com.impaq.ic.cdi.stereotype.power;

import javax.enterprise.inject.Default;
import javax.enterprise.util.AnnotationLiteral;

import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;

public class PowerStationBeanTest extends AbstractCdiTest {

	private PowerStationService powerStationService;

	@Before
	public void setUp() throws Exception {
		setUpWeld();
		powerStationService = getBean(
				com.impaq.ic.cdi.stereotype.power.PowerStationService.class,
				new AnnotationLiteral<Default>() {
				});
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void testListenToMusic() {
		Assertions.assertThat(powerStationService.listenToMusic()).endsWith(
				"Rock0 Rock1 Rock2");
	}

}
