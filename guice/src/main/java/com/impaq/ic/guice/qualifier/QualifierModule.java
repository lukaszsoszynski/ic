package com.impaq.ic.guice.qualifier;

import com.google.inject.AbstractModule;
import com.impaq.ic.guice.qualifier.database.MusicDatabaseBean;
import com.impaq.ic.guice.qualifier.database.MusicDatabaseService;
import com.impaq.ic.guice.qualifier.listgenerator.PlayListGeneratorService;
import com.impaq.ic.guice.qualifier.listgenerator.PopListGeneratorBean;
import com.impaq.ic.guice.qualifier.listgenerator.RockListGeneratorBean;
import com.impaq.ic.guice.qualifier.player.MusicPlayerBean;
import com.impaq.ic.guice.qualifier.player.MusicPlayerService;
import com.impaq.ic.guice.qualifier.qualifier.Pop;
import com.impaq.ic.guice.qualifier.qualifier.Rock;

public class QualifierModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MusicDatabaseService.class).to(MusicDatabaseBean.class);
		bind(PlayListGeneratorService.class).annotatedWith(Rock.class).to(
				RockListGeneratorBean.class);
		bind(PlayListGeneratorService.class).annotatedWith(Pop.class).to(
				PopListGeneratorBean.class);
		bind(MusicPlayerService.class).to(MusicPlayerBean.class);
	}

}
