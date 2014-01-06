package com.impaq.ic.spring.aspect.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.validation.constraints.NotNull;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class NullParameterValidationAspect {
	
//	@Before("com.impaq.ic.spring.aspect.aspect.Pointcuts.everyServiceImpl() && com.impaq.ic.spring.aspect.aspect.Pointcuts.annotatedWithValid()")
	@Before("com.impaq.ic.spring.aspect.aspect.Pointcuts.annotatedWithValid()")
	public void before(JoinPoint joinPoint)
	
			throws Throwable {
		Object[] arguments = joinPoint.getArgs();
		Object thisObject = joinPoint.getTarget();
		Method method = getMethod(joinPoint);
		
		checkInterfaceAnnotations(method, arguments);
		checkImplementationMethod(thisObject, method, arguments);
	}

	private void checkImplementationMethod(Object targetObject, Method method,
			Object[] arguments) throws NoSuchMethodException {
		assert targetObject != null;
		assert method != null;
		
		Method methodImplementation = getImplementationMethod(targetObject, method);
		Annotation[][] allParameterAnnotationsArray = getMethodParametersAnnotations(methodImplementation);
		checkParameterAnnotations(allParameterAnnotationsArray, arguments);
	}

	private Method checkInterfaceAnnotations(Method method,
			Object[] arguments) {
		assert method != null;
		
		
		Annotation[][] allParameterAnnotationsArray = getMethodParametersAnnotations(method);
		checkParameterAnnotations(allParameterAnnotationsArray, arguments);
		return method;
	}

	private Method getImplementationMethod(Object thisObject,
			Method methodInterface) throws NoSuchMethodException {
		assert thisObject != null;
		assert methodInterface != null;
		
		return thisObject.getClass().getMethod(methodInterface.getName(), methodInterface.getParameterTypes());
	}

	private void checkParameterAnnotations(Annotation[][] allParameterAnnotationsArray,
			Object[] arguments) {
		assert allParameterAnnotationsArray != null;
		
		for(int i = 0; i < arguments.length; ++i){
			Annotation[] parameterAnnotations = allParameterAnnotationsArray[i];
			boolean mustBeNotNull = false;
			for(Annotation annotation : parameterAnnotations){
				mustBeNotNull |= annotation.annotationType().isAssignableFrom(NotNull.class);
			}
			if(mustBeNotNull && arguments[i] == null){
				throw new IllegalArgumentException("Argument must not be null");
			}
		}
	}

	private Annotation[][] getMethodParametersAnnotations(Method method) {
		assert method != null;
		
		Annotation[][] allParameterAnnotationsArray = method.getParameterAnnotations();
		return allParameterAnnotationsArray;
	}

	private Method getMethod(JoinPoint joinPoint) {
		assert joinPoint != null;
		
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		return signature.getMethod();
	}
}
