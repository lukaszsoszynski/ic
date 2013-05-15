package com.impaq.ic.cdi.stereotype.stereotype;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;

@Retention(RetentionPolicy.RUNTIME)
@ApplicationScoped
@Stereotype
public @interface Service {

}
