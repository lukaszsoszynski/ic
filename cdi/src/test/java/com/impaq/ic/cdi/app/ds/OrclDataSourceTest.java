package com.impaq.ic.cdi.app.ds;

import javax.enterprise.util.AnnotationLiteral;

import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;
import com.impaq.ic.cdi.app.annotation.ds.Bill;
import com.impaq.ic.cdi.app.annotation.ds.Music;

@Ignore
public class OrclDataSourceTest extends AbstractCdiTest {

	private DataSource billingDataSource;

	private DataSource musicDataSource;

	@Before
	public void setUp() throws Exception {
		setUpWeld();
		billingDataSource = getBean(DataSource.class,
				new AnnotationLiteral<Bill>() {
				});
		musicDataSource = getBean(DataSource.class,
				new AnnotationLiteral<Music>() {
				});
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void testMusicDs() {
		String name = musicDataSource.getConnection().getName();
		Assertions.assertThat(name).isEqualTo("Orcl: music");

	}

	@Test
	public void testBillingDs() {
		String name = billingDataSource.getConnection().getName();
		Assertions.assertThat(name).isEqualTo("Orcl: biling");

	}

}
