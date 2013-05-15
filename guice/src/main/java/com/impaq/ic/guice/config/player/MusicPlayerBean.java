package com.impaq.ic.guice.config.player;

import javax.inject.Inject;
import javax.inject.Named;

import com.impaq.ic.guice.config.listgenerator.PlayListGeneratorService;
import com.impaq.ic.guice.config.listgenerator.PlayListMixerBean;

@Named
public class MusicPlayerBean implements MusicPlayerService {

	private final PlayListGeneratorService playListGeneratorService;

	@Inject
	public MusicPlayerBean(PlayListMixerBean playListMixerBean) {
		if (playListMixerBean == null) {
			throw new IllegalArgumentException(
					"PlayListGeneratorService must not be null");
		}
		this.playListGeneratorService = playListMixerBean;
	}

	public MusicPlayerBean() {
		playListGeneratorService = null;
	}

	@Override
	public String getCurrentPlayedSong() {
		return playListGeneratorService.createPlayList();
	}

}
