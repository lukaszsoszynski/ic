package com.impaq.ic.cdi.event.player;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;
import com.impaq.ic.cdi.event.power.PowerStationService;

public class MusicPlayerBeanTest extends AbstractCdiTest {

	private PowerStationService powerStationService;

	private MusicPlayerService musicPlayerService;

	@Before
	public void setUp() throws Exception {
		powerStationService = setUpWeld(PowerStationService.class);
		musicPlayerService = getBean(MusicPlayerService.class);
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void testNoEvent() {
		assertThat(musicPlayerService.getCurrentPlayedSong()).isEqualTo(
				"Rock0 Rock1 Rock2");
	}

	@Test
	public void testBlackOut() throws InterruptedException {
		assertThat(musicPlayerService.getCurrentPlayedSong()).isEqualTo(
				"Rock0 Rock1 Rock2");

		powerStationService.prepareBlackout(30);

		assertThat(musicPlayerService.getCurrentPlayedSong()).isEqualTo(
				"Blackout expected in 30 minuts.");

	}

	@Test
	public void testBlackOutWithdraw() throws InterruptedException {
		assertThat(musicPlayerService.getCurrentPlayedSong()).isEqualTo(
				"Rock0 Rock1 Rock2");

		powerStationService.prepareBlackout(5);

		assertThat(musicPlayerService.getCurrentPlayedSong()).isEqualTo(
				"Blackout expected in 5 minuts.");

		powerStationService.withdrawBlackout();

		assertThat(musicPlayerService.getCurrentPlayedSong()).isEqualTo(
				"Rock0 Rock1 Rock2");

	}

}
