package com.impaq.ic.cdi.stereotype.power;

import javax.inject.Inject;
import javax.inject.Provider;

import com.impaq.ic.cdi.stereotype.player.MusicPlayerService;
import com.impaq.ic.cdi.stereotype.stereotype.Service;

@Service
public class PowerStationBean implements PowerStationService {

	private final Provider<MusicPlayerService> musicPlayerServiceProvider;

	protected PowerStationBean() {
		this.musicPlayerServiceProvider = null;
	}

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
		// return "ala ma kota";
		return System.identityHashCode(musicPlayerService) + " "
				+ musicPlayerService.getCurrentPlayedSong();
	}

}
