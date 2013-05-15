package com.impaq.ic.guice.config.bindings.justintime;

import com.google.inject.ProvidedBy;

@ProvidedBy(ProvidedByProvider.class)
public interface ProvidedByService {

	boolean isInit();
}
