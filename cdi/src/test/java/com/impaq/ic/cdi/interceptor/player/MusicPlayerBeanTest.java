package com.impaq.ic.cdi.interceptor.player;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;
import com.impaq.ic.cdi.interceptor.interceptor.LogBean;

public class MusicPlayerBeanTest extends AbstractCdiTest {

	private MusicPlayerService musicPlayerService;
	private LogBean logBean;

	@Before
	public void setUp() throws Exception {
		musicPlayerService = setUpWeld(MusicPlayerService.class);
		logBean = getBean(LogBean.class);
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void test() {
		assertThat(musicPlayerService.getCurrentPlayedSong()).isEqualTo(
				"Rock0 Rock1 Rock2");
		assertThat(logBean.getLogs()).isNotEmpty();
	}

}
