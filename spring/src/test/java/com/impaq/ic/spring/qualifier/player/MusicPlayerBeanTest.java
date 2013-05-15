package com.impaq.ic.spring.qualifier.player;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MusicPlayerBeanTest {

	/**
	 * Spring context
	 */
	private AnnotationConfigApplicationContext applicationContext;
	private MusicPlayerService musicPlayerService;

	@Before
	public void setUp() throws Exception {
		applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("com.impaq.ic.spring.qualifier");
		applicationContext.refresh();

		musicPlayerService = applicationContext
				.getBean(MusicPlayerService.class);
	}

	@After
	public void tearDown() throws Exception {
		applicationContext.close();
	}

	@Test
	public void testQualifier() {
		assertThat(musicPlayerService.getCurrentPlayedSong()).isEqualTo(
				"Rock0 Rock1 Rock2");
	}

}
