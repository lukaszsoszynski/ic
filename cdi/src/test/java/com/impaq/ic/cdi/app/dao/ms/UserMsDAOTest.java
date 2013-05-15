package com.impaq.ic.cdi.app.dao.ms;

import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;
import com.impaq.ic.cdi.app.dao.UserDAO;

@Ignore
public class UserMsDAOTest extends AbstractCdiTest {

	private UserDAO userDAO;

	@Before
	public void setUp() throws Exception {
		userDAO = setUpWeld(UserDAO.class);
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void testGetById() {
		Assertions.assertThat(userDAO.getById(8)).isEqualTo("User 8 from M$");
	}

}
