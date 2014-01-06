package com.impaq.ic.spring.aspect;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.impaq.ic.spring.aspect.aspect.JoinPointMethodAnnotationParameterResolver;
import com.impaq.ic.spring.aspect.aspect.JoinPointMethodAnnotationParameterResolverImpl;
import com.impaq.ic.spring.aspect.aspect.NullParameterValidationAspect;
import com.impaq.ic.spring.aspect.aspect.ParameterValidationAspect;
import com.impaq.ic.spring.aspect.service.ValidatedService;
import com.impaq.ic.spring.aspect.service.impl.ValidatedServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfiguration {
	
	@Bean
	@Autowired
	public NullParameterValidationAspect createNullParameterValidationAspect(JoinPointMethodAnnotationParameterResolver joinPointMethodAnnotationParameterResolver){
		return new NullParameterValidationAspect(joinPointMethodAnnotationParameterResolver);
	}
	
	@Bean
	public ValidatedService createValidatedService(){
		return new ValidatedServiceImpl();
	}
	
	@Bean
	public LocalValidatorFactoryBean createLocalValidatorFactoryBean(){
		return new LocalValidatorFactoryBean();
	}
	
	@Bean
	@Autowired
	public ParameterValidationAspect createParameterValidationAspect(JoinPointMethodAnnotationParameterResolver joinPointMethodAnnotationParameterResolver, Validator validator){
		return new ParameterValidationAspect(joinPointMethodAnnotationParameterResolver, validator);
	}
	
	@Bean
	public JoinPointMethodAnnotationParameterResolver createcomJoinPointMethodAnnotationParameterResolverImpl(){
		return new JoinPointMethodAnnotationParameterResolverImpl();
	}
}
