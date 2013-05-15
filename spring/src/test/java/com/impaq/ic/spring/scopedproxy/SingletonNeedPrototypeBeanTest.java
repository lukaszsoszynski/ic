package com.impaq.ic.spring.scopedproxy;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonNeedPrototypeBeanTest {

	/**
	 * Spring context
	 */
	private AnnotationConfigApplicationContext applicationContext;

	@Before
	public void setUp() {
		applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("com.impaq.ic.spring.scopedproxy");
		applicationContext.refresh();
	}

	@After
	public void tearDown() {
		applicationContext.close();
	}

	@Test
	public void contextSetUp() {
		assertThat(applicationContext).isNotNull();
	}

	@Test
	public void shouldIncreaseCount() {
		SingletonNeedPrototype singletonNeedPrototype = applicationContext
				.getBean(SingletonNeedPrototype.class);
		ObjectCounterService objectCountBean = applicationContext
				.getBean(ObjectCounterService.class);

		assertThat(objectCountBean.getObjectCount(PrototypeBean.class))
				.isEqualTo(0);
		assertThat(singletonNeedPrototype.saySth()).isEqualTo("1 Bean no. 1");
		assertThat(objectCountBean.getObjectCount(PrototypeBean.class))
				.isEqualTo(1);
		assertThat(singletonNeedPrototype.saySth()).isEqualTo("2 Bean no. 2");
		assertThat(objectCountBean.getObjectCount(PrototypeBean.class))
				.isEqualTo(2);

	}

}
