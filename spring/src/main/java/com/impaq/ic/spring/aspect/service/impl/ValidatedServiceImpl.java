package com.impaq.ic.spring.aspect.service.impl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.impaq.ic.spring.aspect.aspect.Validable;
import com.impaq.ic.spring.aspect.model.ValidableModelObject;
import com.impaq.ic.spring.aspect.service.ValidatedService;

@Service
@Validable
public class ValidatedServiceImpl implements ValidatedService {

	public static final String NO_PARAMETER_METHOD_OUTPUT = "No parameter method invoked";

	@Override
	public String showValue(Number number) {
		return print(number);
	}

	@Override
	public String printValue(Number number) {
		return print(number);

	}

	@Override
	public String displayValue(@NotNull Number number) {
		return print(number);
	}

	@Override
	public String noParamMethod() {
		return NO_PARAMETER_METHOD_OUTPUT;
	}

	@Override
	public String displayObjectValue(@Valid ValidableModelObject validableModelObject) {
		return print(validableModelObject);
	}
	
	@Override
	public String showObjectValue(ValidableModelObject validableModelObject) {
		return print(validableModelObject);
	}

	private String print(ValidableModelObject validableModelObject) {
		if (validableModelObject == null) {
			return null;
		}
		return print(validableModelObject.toString());
	}
	
	private String print(Object number) {
		String output = "Given number " + number;
		System.out.println(output);
		return output;
	}
}
