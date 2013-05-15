package com.impaq.ic.guice.zoo;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

@Ignore
public class ZooBeanTest {

	private ZooService zooService;

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new ZooModule());
		zooService = injector.getInstance(ZooService.class);
	}

	@Test
	public void testLongPath() {
		Assertions.assertThat(zooService.longPath()).isEqualTo(
				"Person: what a beautifull Rihno Lion Duck");
	}

	@Test
	public void testShortPath() {
		Assertions.assertThat(zooService.shortPath()).isEqualTo(
				"Person: what a beautifull Rihno Duck");
	}

}
