package com.impaq.ic.cdi.app.dao.orcl;

import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;
import com.impaq.ic.cdi.app.dao.BilinglDAO;

@Ignore
public class BillingOrclDAOTest extends AbstractCdiTest {

	private BilinglDAO billDAO;

	@Before
	public void setUp() throws Exception {
		billDAO = setUpWeld(BilinglDAO.class);
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void testGetById() {
		Assertions.assertThat(billDAO.getById(7)).isEqualTo(
				"Bill 7 from Orcl: biling");
	}

}
