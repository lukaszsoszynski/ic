package com.impaq.ic.cdi.app.ui;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;

@Ignore
public class WebUserInterfaceTest extends AbstractCdiTest {

	private UserInterface userInterface;

	@Before
	public void setUp() throws Exception {
		userInterface = setUpWeld(WebUserInterface.class);
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void testGetMusic() {
		assertThat(userInterface.getMusic())
				.isEqualTo(
						"web player nice music from orcl: music for user 7 from m$ cost bill 7 from orcl: biling");
	}

}
