package com.impaq.ic.cdi.app.service.aaa;

import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;

@Ignore
public class AAABeanTest extends AbstractCdiTest {

	private AAAService aaaService;

	@Before
	public void setUp() throws Exception {
		aaaService = setUpWeld(AAAService.class);
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void testGetUser() {
		Assertions.assertThat(aaaService.getUser()).isEqualTo("User 7 from M$");
	}

}
