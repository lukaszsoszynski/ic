package com.impaq.ic.cdi;

import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public abstract class AbstractCdiTest {

	private Weld weld;
	private WeldContainer weldContainer;

	public AbstractCdiTest() {
		super();
	}

	protected <T> T setUpWeld(Class<T> clazz) {
		weld = new Weld();
		weldContainer = weld.initialize();
		if (clazz != null) {
			return getBean(clazz, new AnnotationLiteral<?>[] {});
		}
		return null;
	}

	protected void setUpWeld() {
		setUpWeld(null);
	}

	protected <T> T getBean(Class<T> clazz, AnnotationLiteral<?>... annotations) {
		Instance<T> select = weldContainer.instance()
				.select(clazz, annotations);
		return select.get();
	}

	protected void shutDownWeld() {
		weld.shutdown();
	}

}