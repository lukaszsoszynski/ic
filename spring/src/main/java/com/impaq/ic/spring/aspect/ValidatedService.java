package com.impaq.ic.spring.aspect;

import javax.validation.constraints.NotNull;

public interface ValidatedService {
	
	String showValue(@NotNull Number number);
	
	String printValue(Number number);

	String displayValue(Number object);

	String noParamMethod();

}
