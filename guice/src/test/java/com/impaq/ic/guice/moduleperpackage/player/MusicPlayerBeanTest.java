package com.impaq.ic.guice.moduleperpackage.player;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.impaq.ic.guice.moduleperpackage.PerPackageModule;

public class MusicPlayerBeanTest {

	private MusicPlayerService musicPlayerService;

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new PerPackageModule());
		musicPlayerService = injector.getInstance(MusicPlayerService.class);
	}

	@Test
	public void testGetCurrentPlayedSong() {
		assertThat(musicPlayerService.getCurrentPlayedSong()).isEqualTo(
				"Rock0 Rock1 Rock2");
	}

}
