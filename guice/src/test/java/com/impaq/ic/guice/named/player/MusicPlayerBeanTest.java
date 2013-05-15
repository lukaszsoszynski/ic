package com.impaq.ic.guice.named.player;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.impaq.ic.guice.named.NamedModule;

public class MusicPlayerBeanTest {

	private Injector injector;
	private MusicPlayerBean musicPlayerBean;

	@Before
	public void setUp() throws Exception {
		injector = Guice.createInjector(new NamedModule());
		musicPlayerBean = injector.getInstance(MusicPlayerBean.class);
	}

	@Test
	public void testGetCurrentPlayedSong() {

		assertThat(musicPlayerBean.getCurrentPlayedSong()).isEqualTo(
				"Rock0 Rock1 Rock2");
	}

}
