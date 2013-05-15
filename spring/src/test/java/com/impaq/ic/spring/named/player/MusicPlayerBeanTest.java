package com.impaq.ic.spring.named.player;

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

	@Before
	public void setUp() throws Exception {

		applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("com.impaq.ic.spring.named");
		applicationContext.refresh();
	}

	@After
	public void tearDown() {
		applicationContext.close();
	}

	@Test
	public void test() {
		MusicPlayerService musicPlayerService = applicationContext
				.getBean(MusicPlayerService.class);

		assertThat(musicPlayerService).isNotNull();
	}

}
