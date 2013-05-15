package com.impaq.ic.guice.config.bindings.justintime;

import javax.inject.Inject;

public class JustInTimeBindingBean {

	/**
	 * Class without binding in module
	 */
	private final InjectableClass injectableClass;

	/**
	 * Interface without binding in module
	 */
	private final ImplementedByService implementedByService;

	/**
	 * Interface without binding in module
	 */
	private final ProvidedByService providedByService;

	/**
	 * Constructor
	 * 
	 * @param injectableClass
	 */
	@Inject
	public JustInTimeBindingBean(InjectableClass injectableClass,
			ImplementedByService implementedByService,
			ProvidedByService providedByService) {
		if (injectableClass == null) {
			throw new IllegalStateException("InjectableClass must not be null");
		}
		if (implementedByService == null) {
			throw new IllegalStateException(
					"implementedByService must not be null");
		}
		if (providedByService == null) {
			throw new IllegalStateException(
					"providedByService must not be null");
		}
		this.injectableClass = injectableClass;
		this.implementedByService = implementedByService;
		this.providedByService = providedByService;
	}

	public boolean isInit() {
		return (injectableClass != null) && implementedByService.isInit()
				&& providedByService.isInit();
	}

}
