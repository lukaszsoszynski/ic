package com.impaq.ic.guice.interceptor;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.impaq.ic.guice.interceptor.database.MusicDatabaseBean;
import com.impaq.ic.guice.interceptor.database.MusicDatabaseService;
import com.impaq.ic.guice.interceptor.interceptor.LogBean;
import com.impaq.ic.guice.interceptor.interceptor.LogInterceptor;
import com.impaq.ic.guice.interceptor.interceptor.Loggable;
import com.impaq.ic.guice.interceptor.listgenerator.PlayListGeneratorService;
import com.impaq.ic.guice.interceptor.listgenerator.RockListGeneratorBean;
import com.impaq.ic.guice.interceptor.player.MusicPlayerBean;
import com.impaq.ic.guice.interceptor.player.MusicPlayerService;

public class InterceptorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(LogBean.class);
		bind(MusicPlayerService.class).to(MusicPlayerBean.class);
		bind(PlayListGeneratorService.class).to(RockListGeneratorBean.class);
		bind(MusicDatabaseService.class).to(MusicDatabaseBean.class);

		LogInterceptor logInterceptor = new LogInterceptor();

		requestInjection(logInterceptor);

		bindInterceptor(Matchers.annotatedWith(Loggable.class), Matchers.any(),
				logInterceptor);
	}

}
