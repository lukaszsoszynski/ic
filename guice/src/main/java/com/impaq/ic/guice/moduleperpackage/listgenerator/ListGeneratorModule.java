package com.impaq.ic.guice.moduleperpackage.listgenerator;

import com.google.inject.AbstractModule;
import com.impaq.ic.guice.moduleperpackage.qualifier.Pop;
import com.impaq.ic.guice.moduleperpackage.qualifier.Rock;

public class ListGeneratorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PlayListGeneratorService.class).annotatedWith(Rock.class).to(
				RockListGeneratorBean.class);
		bind(PlayListGeneratorService.class).annotatedWith(Pop.class).to(
				PopListGeneratorBean.class);
	}

}
