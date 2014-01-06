package com.impaq.ic.spring.aspect.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;

public interface JoinPointMethodAnnotationParameterResolver {

	Method getImplementationMethod(Object targerObject, Method methodInterface)
			throws NoSuchMethodException;

	Annotation[][] getMethodParametersAnnotations(Method method);

	Method getMethod(JoinPoint joinPoint);

	boolean isMethodParameterAnnotatedWith(int parameterIndex,
			Annotation[][] allParameterAnnotationsArray,
			Class<?> annotationClass);



}
