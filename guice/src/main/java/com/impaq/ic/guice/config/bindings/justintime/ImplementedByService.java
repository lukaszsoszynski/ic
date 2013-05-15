package com.impaq.ic.guice.config.bindings.justintime;

import com.google.inject.ImplementedBy;

/**
 * Interface without binding in module
 * 
 * @author Lukasz
 * 
 */
@ImplementedBy(ImplementedByBean.class)
public interface ImplementedByService {

	public abstract boolean isInit();

}
