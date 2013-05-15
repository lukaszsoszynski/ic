package com.impaq.ic.guice.config.bindings.buildin;

import java.util.logging.Logger;

import javax.inject.Inject;

import com.google.inject.Injector;
import com.google.inject.Stage;

/**
 * Field injections
 * 
 * @author Lukasz
 * 
 */
public class BuiltInBindingBean {

	@Inject
	private Logger log;

	@Inject
	private Injector injector;

	@Inject
	private Stage stage;

	/**
	 * 
	 * @return
	 */
	public String getLoggerName() {
		return log.getName();
	}

	public boolean isInit() {
		return (injector != null) && (stage != null);
	}

}
