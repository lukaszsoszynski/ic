package com.impaq.ic.spring.interceptor.player;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.impaq.ic.spring.interceptor.interceptor.LogBean;

public class MusicPlayerBeanTest {

	private ClassPathXmlApplicationContext annotationConfigApplicationContext;
	private MusicPlayerService musicPlayerService;
	private LogBean logBean;

	@Before
	public void setUp() throws Exception {
		annotationConfigApplicationContext = new ClassPathXmlApplicationContext(
				"com/impaq/ic/spring/interceptor/player/spring-interceptor.xml");

		musicPlayerService = annotationConfigApplicationContext
				.getBean(MusicPlayerService.class);
		logBean = annotationConfigApplicationContext.getBean(LogBean.class);
	}

	@After
	public void tearDown() throws Exception {
		annotationConfigApplicationContext.close();
	}

	@Test
	public void testGetCurrentPlayedSong() {
		assertThat(logBean.getLogs()).isEmpty();

		assertThat(musicPlayerService.getCurrentPlayedSong()).isEqualTo(
				"Rock0 Rock1 Rock2");

		assertThat(logBean.getLogs()).isNotEmpty();
	}

}
