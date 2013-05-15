package com.impaq.ic.guice.config.bindings.justintime;

import com.impaq.ic.guice.config.database.MusicDatabaseService;

/**
 * Class without binding in module
 * 
 * @author Lukasz
 * 
 */
public class ProvidedByBean implements ProvidedByService {

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
	public ProvidedByBean(MusicDatabaseService musicDatabaseService) {
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
