package com.impaq.ic.spring.aspect.impl;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.impaq.ic.spring.aspect.ValidatedService;
import com.impaq.ic.spring.aspect.aspect.Validable;

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

	private String print(Number number) {
		String output = "Given number " + number;
		System.out.println(output);
		return output;
	}

	@Override
	public String displayValue(@NotNull Number number) {
		return print(number);
	}

	@Override
	public String noParamMethod() {
		return NO_PARAMETER_METHOD_OUTPUT;
	}
}
