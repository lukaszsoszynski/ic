package com.impaq.ic.cdi.inject.listgenerator;

import static org.fest.assertions.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;

public class RockListGeneratorBeanTest extends AbstractCdiTest {

	@Inject
	private PlayListGeneratorService playListGeneratorService;

	@Before
	public void setUp() throws Exception {
		Class<PlayListGeneratorService> clazz = PlayListGeneratorService.class;
		playListGeneratorService = setUpWeld(clazz);
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void test() {
		assertThat(playListGeneratorService.createPlayList()).isEqualTo(
				"Rock0 Rock1 Rock2");
	}

}
