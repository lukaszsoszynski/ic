package com.impaq.ic.cdi.app.dao.orcl;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;
import com.impaq.ic.cdi.app.dao.MusicDAO;

@Ignore
public class MusicOrclDAOTest extends AbstractCdiTest {

	private MusicDAO musicDAO;

	@Before
	public void setUp() throws Exception {
		musicDAO = setUpWeld(MusicDAO.class);
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void testGetMusicByTrackName() {
		assertThat(musicDAO.getMusicByTrackName("name")).isEqualTo(
				"name from Orcl: music");
	}

	@Test
	public void testGetById() {
		assertThat(musicDAO.getById(7)).isEqualTo("Music 7 from Orcl: music");
	}

}
