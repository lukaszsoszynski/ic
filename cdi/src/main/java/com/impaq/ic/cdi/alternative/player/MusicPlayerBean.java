package com.impaq.ic.cdi.alternative.player;

import javax.inject.Inject;

import com.impaq.ic.cdi.alternative.listgenerator.PlayListGeneratorService;

public class MusicPlayerBean implements MusicPlayerService {

	private final PlayListGeneratorService playListGeneratorService;

	@Inject
	public MusicPlayerBean(PlayListGeneratorService playListGeneratorService) {
		if (playListGeneratorService == null) {
			throw new IllegalArgumentException(
					"PlayListGeneratorService must not be null");
		}
		this.playListGeneratorService = playListGeneratorService;
	}

	public MusicPlayerBean() {
		playListGeneratorService = null;
	}

	@Override
	public String getCurrentPlayedSong() {
		return playListGeneratorService.createPlayList();
	}

}
