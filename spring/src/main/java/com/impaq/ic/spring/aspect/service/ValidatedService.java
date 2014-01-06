package com.impaq.ic.spring.aspect.service;

import javax.validation.constraints.NotNull;

import com.impaq.ic.spring.aspect.model.ValidableModelObject;

public interface ValidatedService {
	
	String showValue(@NotNull Number number);
	
	String printValue(Number number);

	String displayValue(Number object);

	String noParamMethod();

	String displayObjectValue(ValidableModelObject validableModelObject);

	String showObjectValue(ValidableModelObject validableModelObject);

}
