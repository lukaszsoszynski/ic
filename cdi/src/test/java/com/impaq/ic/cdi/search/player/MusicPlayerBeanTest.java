package com.impaq.ic.cdi.search.player;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;

public class MusicPlayerBeanTest extends AbstractCdiTest {

	private MusicPlayerService musicPlayerService;

	@Before
	public void setUp() throws Exception {
		musicPlayerService = setUpWeld(MusicPlayerService.class);
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void testGetPopPlayedSong() {
		assertThat(musicPlayerService.getPopPlayedSong()).isEqualTo(
				"Pop0 Pop1 Pop2");
	}

	@Test
	public void testGetRockPlayedSong() {
		assertThat(musicPlayerService.getRockPlayedSong()).isEqualTo(
				"Rock0 Rock1 Rock2");
	}

	@Test
	public void testGetPlayedSong() {
		assertThat(musicPlayerService.getPlayedSong("Hard")).isEqualTo(
				"HardRock0 HardRock1 HardRock2");
	}

}
