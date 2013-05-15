package com.impaq.ic.guice.zoo;


import java.util.ArrayList;
import java.util.List;

import com.google.inject.AbstractModule;


public class ZooModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ZooService.class).to(ZooBean.class);
		bind(Person.class);
		bind(PathService.class).annotatedWith(Long.class)
				.to(LongPathBean.class);
		bind(PathService.class).annotatedWith(Short.class).to(
				ShortPathBean.class);

	}

	public List<AnimalService> listAnimalService() {
		List<AnimalService> listResult = new ArrayList<AnimalService>();
		listResult.add(new AnimalBean("Rihno"));
		listResult.add(new AnimalBean("Lion"));
		listResult.add(new AnimalBean("Duck"));
		return listResult;
	}

}
