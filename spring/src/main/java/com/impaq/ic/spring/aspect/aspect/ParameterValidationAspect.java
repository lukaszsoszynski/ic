package com.impaq.ic.spring.aspect.aspect;

import javax.validation.Validator;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class ParameterValidationAspect {

	private final JoinPointMethodAnnotationParameterResolver joinPointMethodAnnotationParameterResolver;

	private final Validator validator;

	@Autowired
	public ParameterValidationAspect(
			JoinPointMethodAnnotationParameterResolver joinPointMethodAnnotationParameterResolver,
			Validator validator) {
		this.joinPointMethodAnnotationParameterResolver = joinPointMethodAnnotationParameterResolver;
		this.validator = validator;
	}

}
