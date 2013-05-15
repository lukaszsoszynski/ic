package com.impaq.ic.guice.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import com.impaq.ic.guice.config.bindings.buildin.BuiltInBindingBean;
import com.impaq.ic.guice.config.bindings.constructor.ConstructorBindingBean;
import com.impaq.ic.guice.config.bindings.constructor.ConstructorBindingService;
import com.impaq.ic.guice.config.bindings.justintime.JustInTimeBindingBean;
import com.impaq.ic.guice.config.bindings.provider.PowerStationServiceProvider;
import com.impaq.ic.guice.config.database.MusicDatabaseBean;
import com.impaq.ic.guice.config.database.MusicDatabaseService;
import com.impaq.ic.guice.config.listgenerator.PlayListGeneratorService;
import com.impaq.ic.guice.config.listgenerator.PlayListMixerBean;
import com.impaq.ic.guice.config.listgenerator.PopListGeneratorBean;
import com.impaq.ic.guice.config.listgenerator.RockListGeneratorBean;
import com.impaq.ic.guice.config.player.MusicPlayerBean;
import com.impaq.ic.guice.config.player.MusicPlayerService;
import com.impaq.ic.guice.config.power.PowerStationService;
import com.impaq.ic.guice.config.qualifier.Pop;

public class ConfigModule extends AbstractModule {

	@Override
	protected void configure() {

		// Linked Bindings
		bind(MusicDatabaseService.class).to(MusicDatabaseBean.class);

		// Binding Annotations
		bind(PlayListGeneratorService.class).annotatedWith(Names.named("Rock"))
				.to(RockListGeneratorBean.class);
		bind(PlayListGeneratorService.class).annotatedWith(Pop.class).to(
				PopListGeneratorBean.class);

		// Instance Bindings
		bind(String.class).annotatedWith(Names.named("music"))
				.toInstance("Pop");

		// Provider Bindings
		bind(PowerStationService.class).toProvider(
				PowerStationServiceProvider.class);

		// Untargetted Bindings
		bind(PlayListMixerBean.class);

		try {
			// constructor binding
			bind(ConstructorBindingService.class).toConstructor(
					ConstructorBindingBean.class.getConstructor(
							MusicDatabaseService.class,
							PowerStationService.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		// built in bindings
		bind(BuiltInBindingBean.class);

		// just in time binding
		bind(JustInTimeBindingBean.class);

	}

	/**
	 * Provider method binding
	 * 
	 * @param playListGeneratorService
	 *            dependency
	 * @return
	 */
	@Provides
	protected MusicPlayerService provideMusicPlayerService(
			PlayListMixerBean playListMixerBean) {
		return new MusicPlayerBean(playListMixerBean);
	}

}
