package com.impaq.ic.cdi.app.ui;

import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;

@Ignore
public class AndroidUserInterfaceTest extends AbstractCdiTest {

	private UserInterface userInterface;

	@Before
	public void setUp() throws Exception {
		userInterface = setUpWeld(AndroidUserInterface.class);
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void testGetMusic() {
		Assertions
				.assertThat(userInterface.getMusic())
				.isEqualTo(
						"Android player: Nice music from Orcl: music for User 7 from M$ cost Bill 7 from Orcl: biling");
	}

}
