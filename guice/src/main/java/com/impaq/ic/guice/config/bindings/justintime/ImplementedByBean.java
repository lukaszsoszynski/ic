package com.impaq.ic.guice.config.bindings.justintime;

import javax.inject.Inject;

import com.impaq.ic.guice.config.database.MusicDatabaseService;

public class ImplementedByBean implements ImplementedByService {

	private final MusicDatabaseService musicDatabaseService;

	@Inject
	public ImplementedByBean(MusicDatabaseService musicDatabaseService) {
		if (musicDatabaseService == null) {
			throw new IllegalArgumentException(
					"MusicDatabaseService must not be null");
		}
		this.musicDatabaseService = musicDatabaseService;
	}

	@Override
	public boolean isInit() {
		return musicDatabaseService != null;
	}

}
