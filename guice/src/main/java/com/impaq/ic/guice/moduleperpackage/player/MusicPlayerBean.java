package com.impaq.ic.guice.moduleperpackage.player;

import javax.inject.Inject;

import com.impaq.ic.guice.moduleperpackage.listgenerator.PlayListGeneratorService;
import com.impaq.ic.guice.moduleperpackage.qualifier.Rock;

class MusicPlayerBean implements MusicPlayerService {

	private final PlayListGeneratorService playListGeneratorService;

	@Inject
	MusicPlayerBean(@Rock PlayListGeneratorService playListGeneratorService) {
		if (playListGeneratorService == null) {
			throw new IllegalArgumentException(
					"PlayListGeneratorService must not be null");
		}
		this.playListGeneratorService = playListGeneratorService;
	}

	@Override
	public String getCurrentPlayedSong() {
		return playListGeneratorService.createPlayList();
	}

}
