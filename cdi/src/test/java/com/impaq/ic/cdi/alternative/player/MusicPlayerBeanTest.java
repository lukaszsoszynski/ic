/**
 * 
 */
package com.impaq.ic.cdi.alternative.player;

import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;

/**
 * @author lsos
 * 
 */
public class MusicPlayerBeanTest extends AbstractCdiTest {

	private MusicPlayerService musicPlayerService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.musicPlayerService = setUpWeld(MusicPlayerService.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void test() {
		Assertions.assertThat(musicPlayerService.getCurrentPlayedSong())
				.isEqualTo("Alternative0 Alternative1 Alternative2");
	}

}
