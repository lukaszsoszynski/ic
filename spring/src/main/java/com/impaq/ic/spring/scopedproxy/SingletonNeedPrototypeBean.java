package com.impaq.ic.spring.scopedproxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * https://jira.springsource.org/browse/SPR-5192
 * 
 * @author Lukasz
 * 
 */
@Component
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class SingletonNeedPrototypeBean implements SingletonNeedPrototype {

	/**
	 * Object counter service
	 */
	private final ObjectCounterService objectCounterService;

	/**
	 * Scoped proxy
	 */
	private final IPrototypeBean prototypeBean;

	/**
	 * Constructor
	 * 
	 * @param objectCounterService
	 */
	@Autowired
	public SingletonNeedPrototypeBean(
			ObjectCounterService objectCounterService,
			IPrototypeBean prototypeBean) {
		if (objectCounterService == null) {
			throw new IllegalArgumentException(
					"ObjectCounterService must not be null");
		}
		if (prototypeBean == null) {
			throw new IllegalArgumentException("prototypeBean must not be null");
		}
		this.objectCounterService = objectCounterService;
		this.prototypeBean = prototypeBean;
	}

	/**
	 * Inject {@link PrototypeBean}
	 * 
	 * @return injected {@link PrototypeBean} instance
	 */
	private IPrototypeBean getPrototypeBean() {
		return prototypeBean;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String saySth() {
		IPrototypeBean prototypeBean = getPrototypeBean();
		String name = prototypeBean.getName();
		long count = objectCounterService.getObjectCount(PrototypeBean.class);
		return "" + count + " " + name;
	}
}
