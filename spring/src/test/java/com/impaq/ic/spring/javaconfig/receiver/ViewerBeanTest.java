package com.impaq.ic.spring.javaconfig.receiver;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.impaq.ic.spring.javaconfig.AppConfig;

public class ViewerBeanTest {

	private AnnotationConfigApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		this.applicationContext = new AnnotationConfigApplicationContext(
				AppConfig.class);
	}

	@After
	public void tearDown() throws Exception {
		applicationContext.close();
	}

	@Test
	public void testAppContext() {
		assertThat(applicationContext).isNotNull();
	}

	@Test
	public void testViewer() {
		ViewerService viewer = applicationContext.getBean(ViewerService.class);

		assertThat(viewer).isNotNull();

		assertThat(viewer.view()).isEqualTo("viewer: sony: g s w");

	}

}
