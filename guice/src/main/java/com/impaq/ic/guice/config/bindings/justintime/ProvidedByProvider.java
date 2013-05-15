package com.impaq.ic.guice.config.bindings.justintime;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.impaq.ic.guice.config.database.MusicDatabaseService;

public class ProvidedByProvider implements Provider<ProvidedByService> {

	/**
	 * Injected service
	 */
	private final MusicDatabaseService musicDatabaseService;

	/**
	 * Constructor
	 * 
	 * @param musicDatabaseService
	 *            must not be <code>null</code>.
	 */
	@Inject
	public ProvidedByProvider(MusicDatabaseService musicDatabaseService) {
		if (musicDatabaseService == null) {
			throw new IllegalArgumentException(
					"MusicDatabaseService must not be null");
		}
		this.musicDatabaseService = musicDatabaseService;
	}

	@Override
	public ProvidedByService get() {
		return new ProvidedByBean(musicDatabaseService);
	}

}
