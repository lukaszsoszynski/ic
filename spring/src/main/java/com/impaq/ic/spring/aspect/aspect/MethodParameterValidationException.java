package com.impaq.ic.spring.aspect.aspect;

import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;

public class MethodParameterValidationException extends
		IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	private final Set<ConstraintViolation<Object>> constraintsViolations;

	MethodParameterValidationException(
			Set<ConstraintViolation<Object>> constraintsViolations) {
		super("Parameter validation error");
		this.constraintsViolations = Collections
				.unmodifiableSet(constraintsViolations);
	}

	public Set<ConstraintViolation<Object>> getConstraintsViolations() {
		return constraintsViolations;
	}

}
