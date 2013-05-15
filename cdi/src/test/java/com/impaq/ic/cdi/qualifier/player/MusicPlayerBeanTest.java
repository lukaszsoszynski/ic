package com.impaq.ic.cdi.qualifier.player;

import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;

public class MusicPlayerBeanTest extends AbstractCdiTest {

	/**
	 * Injector
	 */
	private MusicPlayerService musicPlayerService;

	@Before
	public void setUp() throws Exception {
		musicPlayerService = setUpWeld(MusicPlayerService.class);
	}

	@After
	public void ternDown() {
		shutDownWeld();
	}

	@Test
	public void testGetCurrentPlayedSong() {
		Assertions.assertThat(musicPlayerService.getCurrentPlayedSong())
				.isEqualTo("Rock0 Rock1 Rock2");
	}

}
