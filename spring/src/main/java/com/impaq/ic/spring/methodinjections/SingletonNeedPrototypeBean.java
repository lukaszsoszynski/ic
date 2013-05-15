package com.impaq.ic.spring.methodinjections;

/**
 * https://jira.springsource.org/browse/SPR-5192
 * 
 * @author Lukasz
 * 
 */
public abstract class SingletonNeedPrototypeBean implements
		SingletonNeedPrototype {

	/**
	 * Object counter service
	 */
	private final ObjectCounterService objectCounterService;

	/**
	 * Constructor
	 * 
	 * @param objectCounterService
	 */
	public SingletonNeedPrototypeBean(ObjectCounterService objectCounterService) {
		if (objectCounterService == null) {
			throw new IllegalArgumentException(
					"ObjectCounterService must not be null");
		}
		this.objectCounterService = objectCounterService;
	}

	/**
	 * Inject {@link PrototypeBean}
	 * 
	 * @return injected {@link PrototypeBean} instance
	 */
	protected abstract PrototypeBean getPrototypeBean();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String saySth() {
		PrototypeBean prototypeBean = getPrototypeBean();
		long count = objectCounterService.getObjectCount(prototypeBean
				.getClass());
		return "" + count + " " + prototypeBean.getName();
	}
}
