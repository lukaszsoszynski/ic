package com.impaq.ic.guice.provider;

import com.google.inject.AbstractModule;
import com.impaq.ic.guice.provider.database.MusicDatabaseBean;
import com.impaq.ic.guice.provider.database.MusicDatabaseService;
import com.impaq.ic.guice.provider.listgenerator.PlayListGeneratorService;
import com.impaq.ic.guice.provider.listgenerator.RockListGeneratorBean;
import com.impaq.ic.guice.provider.player.MusicPlayerBean;
import com.impaq.ic.guice.provider.player.MusicPlayerService;
import com.impaq.ic.guice.provider.power.PowerStationBean;
import com.impaq.ic.guice.provider.power.PowerStationService;

public class ProviderModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MusicDatabaseService.class).to(MusicDatabaseBean.class);
		bind(PlayListGeneratorService.class).to(RockListGeneratorBean.class);
		bind(MusicPlayerService.class).to(MusicPlayerBean.class);
		bind(PowerStationService.class).to(PowerStationBean.class);

	}

}
