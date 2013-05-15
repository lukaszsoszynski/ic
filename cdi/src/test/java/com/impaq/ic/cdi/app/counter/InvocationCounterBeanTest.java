package com.impaq.ic.cdi.app.counter;

import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;
import com.impaq.ic.cdi.app.service.billing.BillingService;

@Ignore
public class InvocationCounterBeanTest extends AbstractCdiTest {

	private BillingService billingService;
	private InvocationCounterServins invocationCounterServins;

	@Before
	public void setUp() throws Exception {
		billingService = setUpWeld(BillingService.class);
		invocationCounterServins = getBean(InvocationCounterServins.class);
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void testGetCount() {
		Assertions.assertThat(invocationCounterServins.getCount()).isEqualTo(0);

		billingService.getBill("name");

		Assertions.assertThat(invocationCounterServins.getCount()).isEqualTo(1);
	}

}
