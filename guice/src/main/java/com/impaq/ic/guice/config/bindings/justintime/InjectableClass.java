package com.impaq.ic.guice.config.bindings.justintime;

/**
 * Class with default constructor is injectable without binding
 * 
 * @author Lukasz
 * 
 */
public class InjectableClass {

	boolean injectable;

	public boolean isInjectable() {
		return injectable;
	}

	public void setInjectable(boolean injectable) {
		this.injectable = injectable;
	}

}
