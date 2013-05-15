package com.impaq.ic.guice.moduleperpackage.database;

import com.google.inject.AbstractModule;

public class DatabaseModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MusicDatabaseService.class).to(MusicDatabaseBean.class);
	}

}
