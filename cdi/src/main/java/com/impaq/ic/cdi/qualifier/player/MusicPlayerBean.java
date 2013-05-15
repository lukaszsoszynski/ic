package com.impaq.ic.cdi.qualifier.player;

import javax.inject.Inject;

import com.impaq.ic.cdi.qualifier.listgenerator.PlayListGeneratorService;
import com.impaq.ic.cdi.qualifier.qualifier.Rock;

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

	@Override
	public String getCurrentPlayedSong() {
		return playListGeneratorService.createPlayList();
	}

}
