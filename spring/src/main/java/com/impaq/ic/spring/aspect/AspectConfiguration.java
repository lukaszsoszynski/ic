package com.impaq.ic.spring.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.impaq.ic.spring.aspect.aspect.NullParameterValidationAspect;
import com.impaq.ic.spring.aspect.service.ValidatedService;
import com.impaq.ic.spring.aspect.service.impl.ValidatedServiceImpl;

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
	
	@Bean
	public LocalValidatorFactoryBean createLocalValidatorFactoryBean(){
		return new LocalValidatorFactoryBean();
	}
}
