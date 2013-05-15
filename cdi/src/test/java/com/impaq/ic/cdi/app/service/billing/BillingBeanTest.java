package com.impaq.ic.cdi.app.service.billing;

import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;

@Ignore
public class BillingBeanTest extends AbstractCdiTest {

	private BillingService billingService;

	@Before
	public void setUp() throws Exception {
		billingService = setUpWeld(BillingService.class);
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void testGetBill() {
		Assertions.assertThat(billingService.getBill("Ala")).isEqualTo(
				"Bill 7 from Orcl: biling");
	}

}
