package com.impaq.ic.spring.aspect.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.validation.constraints.NotNull;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class NullParameterValidationAspect {

	private final JoinPointMethodAnnotationParameterResolver joinPointMethodAnnotationParameterResolver;

	public NullParameterValidationAspect(
			JoinPointMethodAnnotationParameterResolver joinPointMethodAnnotationParameterResolver) {
		this.joinPointMethodAnnotationParameterResolver = joinPointMethodAnnotationParameterResolver;
	}

	// @Before("com.impaq.ic.spring.aspect.aspect.Pointcuts.everyServiceImpl() && com.impaq.ic.spring.aspect.aspect.Pointcuts.annotatedWithValid()")
	@Before("com.impaq.ic.spring.aspect.aspect.Pointcuts.annotatedWithValid()")
	public void before(JoinPoint joinPoint)
	throws Throwable {
		Object[] arguments = joinPoint.getArgs();
		Object thisObject = joinPoint.getTarget();
		Method method = joinPointMethodAnnotationParameterResolver
				.getMethod(joinPoint);

		checkInterfaceAnnotations(method, arguments);
		checkImplementationMethod(thisObject, method, arguments);
	}

	private void checkImplementationMethod(Object targetObject, Method method,
			Object[] arguments) throws NoSuchMethodException {
		assert targetObject != null;
		assert method != null;

		Method methodImplementation = joinPointMethodAnnotationParameterResolver
				.getImplementationMethod(targetObject, method);
		Annotation[][] allParameterAnnotationsArray = joinPointMethodAnnotationParameterResolver
				.getInterfaveMethodParametersAnnotations(methodImplementation);
		checkParameterAnnotations(allParameterAnnotationsArray, arguments);
	}

	private Method checkInterfaceAnnotations(Method method, Object[] arguments) {
		assert method != null;

		Annotation[][] allParameterAnnotationsArray = joinPointMethodAnnotationParameterResolver
				.getInterfaveMethodParametersAnnotations(method);
		checkParameterAnnotations(allParameterAnnotationsArray, arguments);
		return method;
	}

	private void checkParameterAnnotations(
			Annotation[][] allParameterAnnotationsArray, Object[] arguments) {
		assert allParameterAnnotationsArray != null;

		for (int i = 0; i < arguments.length; ++i) {
			boolean mustBeNotNull = joinPointMethodAnnotationParameterResolver
					.isMethodParameterAnnotatedWith(i,
							allParameterAnnotationsArray, NotNull.class);
			if (mustBeNotNull && arguments[i] == null) {
				throw new IllegalArgumentException("Argument must not be null");
			}
		}
	}

}
