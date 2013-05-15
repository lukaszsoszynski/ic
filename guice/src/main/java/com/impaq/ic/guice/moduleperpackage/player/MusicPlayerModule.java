package com.impaq.ic.guice.moduleperpackage.player;

import com.google.inject.AbstractModule;

public class MusicPlayerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MusicPlayerService.class).to(MusicPlayerBean.class);
	}

}
