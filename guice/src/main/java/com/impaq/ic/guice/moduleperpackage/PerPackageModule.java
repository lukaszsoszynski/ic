package com.impaq.ic.guice.moduleperpackage;

import com.google.inject.AbstractModule;
import com.impaq.ic.guice.moduleperpackage.database.DatabaseModule;
import com.impaq.ic.guice.moduleperpackage.listgenerator.ListGeneratorModule;
import com.impaq.ic.guice.moduleperpackage.player.MusicPlayerModule;

public class PerPackageModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new DatabaseModule());
		install(new ListGeneratorModule());
		install(new MusicPlayerModule());
	}

}
