package com.impaq.ic.guice.config.bindings.provider;

import javax.inject.Inject;

import com.google.inject.Provider;
import com.impaq.ic.guice.config.player.MusicPlayerService;
import com.impaq.ic.guice.config.power.PowerStationBean;
import com.impaq.ic.guice.config.power.PowerStationService;

/**
 * When provider method is to long use provider class.
 * 
 * @author Lukasz
 * 
 */
public class PowerStationServiceProvider implements
		Provider<PowerStationService> {

	private final Provider<MusicPlayerService> musicPlayerServiceProvider;

	/**
	 * Constructor
	 * 
	 * @param musicPlayerServiceProvider
	 */
	@Inject
	public PowerStationServiceProvider(
			Provider<MusicPlayerService> musicPlayerServiceProvider) {
		if (musicPlayerServiceProvider == null) {
			throw new IllegalArgumentException(
					"musicPlayerServiceProvider must not be null");
		}
		this.musicPlayerServiceProvider = musicPlayerServiceProvider;
	}

	@Override
	public PowerStationService get() {
		return new PowerStationBean(musicPlayerServiceProvider);
	}

}
