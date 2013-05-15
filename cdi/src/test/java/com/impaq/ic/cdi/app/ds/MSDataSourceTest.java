package com.impaq.ic.cdi.app.ds;

import static org.fest.assertions.Assertions.assertThat;

import javax.enterprise.util.AnnotationLiteral;

import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.impaq.ic.cdi.AbstractCdiTest;
import com.impaq.ic.cdi.app.annotation.ds.MS;

@Ignore
public class MSDataSourceTest extends AbstractCdiTest {

	private DataSource dataSource;

	@Before
	public void setUp() throws Exception {
		setUpWeld();
		dataSource = getBean(DataSource.class, new AnnotationLiteral<MS>() {
		});
	}

	@After
	public void tearDown() throws Exception {
		shutDownWeld();
	}

	@Test
	public void testMsDsFound() {
		Assertions.assertThat(dataSource).isNotNull();
	}

	@Test
	public void testGetConnection() {
		assertThat(dataSource.getConnection().getName()).isEqualTo("M$");
	}

}
