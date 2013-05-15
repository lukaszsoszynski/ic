package com.impaq.ic.guice.inject.listgenerator;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.impaq.ic.guice.inject.BasicModule;

public class RockListGeneratorBeanTest {

	private Injector injector;
	private PlayListGeneratorService playListGeneratorService;

	@Before
	public void setUp() throws Exception {
		injector = Guice.createInjector(new BasicModule());
		this.playListGeneratorService = injector
				.getInstance(PlayListGeneratorService.class);
	}

	@Test
	public void testCreatePlayList() {
		assertThat(playListGeneratorService.createPlayList()).isEqualTo(
				"Rock0 Rock1 Rock2");
	}

}
