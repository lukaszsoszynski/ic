package com.impaq.ic.spring.methodinjections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PrototypeBean {

	/**
	 * Bean property
	 */
	private String name;

	/**
	 * Constructor
	 * 
	 * @param objectCounterService
	 *            must not be <code>null</code>.
	 */
	@Autowired
	public PrototypeBean(ObjectCounterService objectCounterService) {
		if (objectCounterService == null) {
			throw new IllegalArgumentException(
					"objectCounterService must not be null");
		}
		this.name = "Bean no. " + objectCounterService.addObject(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
