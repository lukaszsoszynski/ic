package com.impaq.ic.guice.inject;

import com.google.inject.AbstractModule;
import com.impaq.ic.guice.inject.database.MusicDatabaseBean;
import com.impaq.ic.guice.inject.database.MusicDatabaseService;
import com.impaq.ic.guice.inject.listgenerator.PlayListGeneratorService;
import com.impaq.ic.guice.inject.listgenerator.RockListGeneratorBean;

public class BasicModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MusicDatabaseService.class).to(MusicDatabaseBean.class);
		bind(PlayListGeneratorService.class).to(RockListGeneratorBean.class);
	}

}
