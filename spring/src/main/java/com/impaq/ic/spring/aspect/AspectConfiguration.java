package com.impaq.ic.spring.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.impaq.ic.spring.aspect.aspect.NullParameterValidationAspect;
import com.impaq.ic.spring.aspect.impl.ValidatedServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfiguration {
	
	@Bean
	public NullParameterValidationAspect createNullParameterValidationAspect(){
		return new NullParameterValidationAspect();
	}
	
	@Bean
	public ValidatedService createValidatedService(){
		return new ValidatedServiceImpl();
	}
		
}
