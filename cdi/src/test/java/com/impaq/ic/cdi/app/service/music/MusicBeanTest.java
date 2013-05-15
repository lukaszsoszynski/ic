package com.impaq.ic.cdi.app.service.music;

import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;

@Ignore
public class MusicBeanTest extends AbstractCdiTest {

	private MusicService musicService;

	@Before
	public void setUp() throws Exception {
		musicService = setUpWeld(MusicService.class);
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void testServeMusic() {
		Assertions
				.assertThat(musicService.serveMusic())
				.isEqualTo(
						"Nice music from Orcl: music for User 7 from M$ cost Bill 7 from Orcl: biling");
	}

}
