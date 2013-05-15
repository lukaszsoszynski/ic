package com.impaq.ic.guice.qualifier.player;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.impaq.ic.guice.qualifier.QualifierModule;

public class MusicPlayerBeanTest {

	/**
	 * Injector
	 */
	private Injector injector;
	private MusicPlayerService musicPlayerService;

	@Before
	public void setUp() throws Exception {
		injector = Guice.createInjector(new QualifierModule());
		musicPlayerService = injector.getInstance(MusicPlayerService.class);
	}

	@Test
	public void testGetCurrentPlayedSong() {
		Assertions.assertThat(musicPlayerService.getCurrentPlayedSong())
				.isEqualTo("Rock0 Rock1 Rock2");
	}

}
