package com.impaq.ic.guice.provider.power;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.google.inject.Provider;
import com.impaq.ic.guice.provider.player.MusicPlayerService;

@Named
@Singleton
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
