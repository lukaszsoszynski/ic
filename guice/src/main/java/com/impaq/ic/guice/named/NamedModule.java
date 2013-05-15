package com.impaq.ic.guice.named;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.impaq.ic.guice.named.database.MusicDatabaseBean;
import com.impaq.ic.guice.named.database.MusicDatabaseService;
import com.impaq.ic.guice.named.listgenerator.PlayListGeneratorService;
import com.impaq.ic.guice.named.listgenerator.PopListGeneratorBean;
import com.impaq.ic.guice.named.listgenerator.RockListGeneratorBean;
import com.impaq.ic.guice.named.player.MusicPlayerBean;
import com.impaq.ic.guice.named.player.MusicPlayerService;

public class NamedModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MusicDatabaseService.class).to(MusicDatabaseBean.class);
		bind(PlayListGeneratorService.class).annotatedWith(Names.named("Rock"))
				.to(RockListGeneratorBean.class);
		bind(PlayListGeneratorService.class).annotatedWith(Names.named("Pop"))
				.to(PopListGeneratorBean.class);
		bind(MusicPlayerService.class).to(MusicPlayerBean.class);
	}

}
