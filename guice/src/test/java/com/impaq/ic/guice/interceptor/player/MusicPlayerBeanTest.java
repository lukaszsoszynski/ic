package com.impaq.ic.guice.interceptor.player;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.impaq.ic.guice.interceptor.InterceptorModule;
import com.impaq.ic.guice.interceptor.interceptor.LogBean;

public class MusicPlayerBeanTest {

	private MusicPlayerService musicPlayerService;
	private LogBean logBean;

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new InterceptorModule());

		logBean = injector.getInstance(LogBean.class);
		musicPlayerService = injector.getInstance(MusicPlayerService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCurrentPlayedSong() {
		assertThat(logBean.getLogs()).isEmpty();

		assertThat(musicPlayerService.getCurrentPlayedSong()).isEqualTo(
				"Rock0 Rock1 Rock2");

		assertThat(logBean.getLogs()).isNotEmpty();
	}

}
