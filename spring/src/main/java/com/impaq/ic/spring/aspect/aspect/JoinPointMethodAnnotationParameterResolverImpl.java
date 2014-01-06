package com.impaq.ic.spring.aspect.aspect;

import static org.springframework.util.Assert.notNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public class JoinPointMethodAnnotationParameterResolverImpl implements
		JoinPointMethodAnnotationParameterResolver {

	@Override
	public Method getImplementationMethod(Object targerObject,
			Method methodInterface) throws NoSuchMethodException {
		notNull( targerObject, "Targer object must not be null" );
		assert methodInterface != null;
		
		return targerObject.getClass().getMethod(methodInterface.getName(), methodInterface.getParameterTypes());
	}

	@Override
	public Annotation[][] getMethodParametersAnnotations(Method method) {
		notNull(method, "Method must not be null");
		
		Annotation[][] allParameterAnnotationsArray = method.getParameterAnnotations();
		return allParameterAnnotationsArray;
	}
	
	@Override
	public Method getMethod(JoinPoint joinPoint) {
		notNull( joinPoint , "Joinpoint must not be null");
		
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		return signature.getMethod();
	}
}
