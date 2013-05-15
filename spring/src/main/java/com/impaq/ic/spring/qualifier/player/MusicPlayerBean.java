package com.impaq.ic.spring.qualifier.player;

import javax.inject.Inject;
import javax.inject.Named;

import com.impaq.ic.spring.qualifier.listgenerator.PlayListGeneratorService;
import com.impaq.ic.spring.qualifier.qualifier.Rock;

@Named
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
