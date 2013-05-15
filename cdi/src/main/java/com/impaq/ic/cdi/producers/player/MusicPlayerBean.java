package com.impaq.ic.cdi.producers.player;

import javax.inject.Inject;

import com.impaq.ic.cdi.producers.listgenerator.PlayListGeneratorService;
import com.impaq.ic.cdi.producers.qualifier.Rock;

public class MusicPlayerBean implements MusicPlayerService {

	private final PlayListGeneratorService playListGeneratorService;

	@Inject
	public MusicPlayerBean(
			@Rock PlayListGeneratorService playListGeneratorService) {
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
