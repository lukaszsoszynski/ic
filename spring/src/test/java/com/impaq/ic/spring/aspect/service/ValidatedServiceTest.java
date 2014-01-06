package com.impaq.ic.spring.aspect.service;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.impaq.ic.spring.aspect.AspectConfiguration;
import com.impaq.ic.spring.aspect.aspect.MethodParameterValidationException;
import com.impaq.ic.spring.aspect.model.ValidableModelObject;
import com.impaq.ic.spring.aspect.service.ValidatedService;
import com.impaq.ic.spring.aspect.service.impl.ValidatedServiceImpl;

public class ValidatedServiceTest {

	private GenericApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		this.applicationContext = new AnnotationConfigApplicationContext(
				AspectConfiguration.class);
	}

	@After
	public void tearDown() throws Exception {
		if (applicationContext != null) {
			applicationContext.close();
		}
	}

	@Test
	public void shouldApplicationContextContainsValidatedService() {

		// when
		ValidatedService validatedService = getValidatedService();

		// then
		assertThat(validatedService).isNotNull();
	}

	@Test
	public void shouldPrintNumber() {
		// given
		ValidatedService validatedService = getValidatedService();

		// when
		String output = validatedService.printValue(1410);

		// then
		assertThat(output).isEqualTo("Given number 1410");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowNullArgumentAnnotationInInterface() {
		// given
		ValidatedService validatedService = getValidatedService();

		// when
		validatedService.displayValue(null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowNullArgumentAnnotationInImplementation() {
		// given
		ValidatedService validatedService = getValidatedService();

		// when
		validatedService.displayValue(null);

	}

	@Test
	public void shouldPrintNullArgument() {
		// given
		ValidatedService validatedService = getValidatedService();

		// when
		String output = validatedService.printValue(null);

		// then
		assertThat(output).isEqualTo("Given number null");
	}

	@Test
	public void shouldInvokeNoParameterMethod() {
		// given
		ValidatedService validatedService = getValidatedService();
		
		//when
		String output = validatedService.noParamMethod();
		
		//then
		assertThat(output).isEqualTo(ValidatedServiceImpl.NO_PARAMETER_METHOD_OUTPUT);
	}
	
	@Test(expected = MethodParameterValidationException.class)
	public void shouldValidateMethodParameter(){
		// given
		ValidatedService validatedService = getValidatedService();
		ValidableModelObject validableModelObject = createIncorrectObject();
		
		//when
		validatedService.displayObjectValue(validableModelObject);
		
	}
	
	@Test
	public void shouldNotValidateMethodParameter(){
		// given
		ValidatedService validatedService = getValidatedService();
		ValidableModelObject validableModelObject = createIncorrectObject();
		
		//when
		String displayedValue = validatedService.showObjectValue(validableModelObject);
		
		//then
		assertThat(displayedValue).startsWith("Given number");
		
	}

	private ValidableModelObject createIncorrectObject() {
		ValidableModelObject validableModelObject = new ValidableModelObject();
		validableModelObject.setFamilyname("S");
		validableModelObject.setFirstName(null);
		validableModelObject.setBirthDate(new Date(0));
		return validableModelObject;
	}

	private ValidatedService getValidatedService() {
		return applicationContext.getBean(ValidatedService.class);
	}

}
