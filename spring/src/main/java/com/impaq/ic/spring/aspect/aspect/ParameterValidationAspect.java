package com.impaq.ic.spring.aspect.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

	@Before("com.impaq.ic.spring.aspect.aspect.Pointcuts.annotatedWithValid()")
	public void validateMethidInvocationParameters(JoinPoint joinPoint)
			throws NoSuchMethodException {
		Object[] arguments = joinPoint.getArgs();
		Object targerObject = joinPoint.getTarget();
		Method method = joinPointMethodAnnotationParameterResolver
				.getMethod(joinPoint);

		Annotation[][] interfaceParameterAnnotations = joinPointMethodAnnotationParameterResolver
				.getInterfaveMethodParametersAnnotations(method);
		Method implementationMethod = joinPointMethodAnnotationParameterResolver
				.getImplementationMethod(targerObject, method);
		Annotation[][] implementationParameterAnnotation = joinPointMethodAnnotationParameterResolver
				.getInterfaveMethodParametersAnnotations(implementationMethod);

		Set<ConstraintViolation<Object>> constraintsViolations = new HashSet<ConstraintViolation<Object>>();

		for (int i = 0; i < arguments.length; ++i) {
			Object objectForValidation = arguments[i];
			if (isParameterValidationRequired(interfaceParameterAnnotations,
					implementationParameterAnnotation, objectForValidation, i)) {
				constraintsViolations.addAll(validator.validate(
						objectForValidation, Default.class));
			}
		}

		if (constraintsViolations.size() > 0) {
			throw new MethodParameterValidationException(constraintsViolations);
		}
	}

	private boolean isParameterValidationRequired(
			Annotation[][] interfaceParameterAnnotations,
			Annotation[][] implementationParameterAnnotations,
			Object objectForValidation, int parameterIndex) {
		assert interfaceParameterAnnotations != null;
		assert implementationParameterAnnotations != null;
		assert parameterIndex >= 0;

		boolean interfacaAnnotatedWithValid = joinPointMethodAnnotationParameterResolver
				.isMethodParameterAnnotatedWith(parameterIndex,
						interfaceParameterAnnotations, Valid.class);
		boolean implementationAnnotatedWithValis = joinPointMethodAnnotationParameterResolver
				.isMethodParameterAnnotatedWith(parameterIndex,
						implementationParameterAnnotations, Valid.class);
		return (objectForValidation != null)
				&& (interfacaAnnotatedWithValid || implementationAnnotatedWithValis);
	}

}
