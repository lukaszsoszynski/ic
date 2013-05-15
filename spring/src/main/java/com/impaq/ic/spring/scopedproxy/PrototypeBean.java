package com.impaq.ic.spring.scopedproxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.INTERFACES)
public class PrototypeBean implements IPrototypeBean {

	/**
	 * Bean property
	 */
	private String name;

	/**
	 * Constructor
	 * 
	 * @param objectCounterService
	 */
	@Autowired
	public PrototypeBean(ObjectCounterService objectCounterService) {
		this.name = "Bean no. "
				+ objectCounterService.addObject(PrototypeBean.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impaq.ic.spring.scopedproxy.IPropertyBean#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impaq.ic.spring.scopedproxy.IPropertyBean#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
}
