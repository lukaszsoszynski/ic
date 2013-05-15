package com.impaq.ic.cdi.producers.power;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Provider;

import com.impaq.ic.cdi.producers.player.MusicPlayerService;

@ApplicationScoped
public class PowerStationBean implements PowerStationService {

	private final Provider<MusicPlayerService> musicPlayerServiceProvider;

	@Inject
	public PowerStationBean(
			Provider<MusicPlayerService> musicPlayerServiceProvider) {
		if (musicPlayerServiceProvider == null) {
			throw new IllegalArgumentException(
					"musicPlayerServiceProvider must not be null");
		}
		this.musicPlayerServiceProvider = musicPlayerServiceProvider;
	}

	protected PowerStationBean() {
		musicPlayerServiceProvider = null;
	}

	@Override
	public boolean isPowerOn() {
		return true;
	}

	@Override
	public String listenToMusic() {
		MusicPlayerService musicPlayerService = musicPlayerServiceProvider
				.get();

		return System.identityHashCode(musicPlayerService) + " "
				+ musicPlayerService.getCurrentPlayedSong();
	}

}
