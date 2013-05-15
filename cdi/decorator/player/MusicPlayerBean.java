package com.impaq.ic.cdi.decorator.player;

import javax.inject.Inject;
import javax.inject.Named;

import com.impaq.ic.cdi.decorator.listgenerator.PlayListGeneratorService;



@Named
public class MusicPlayerBean implements MusicPlayerService {
	
	private final PlayListGeneratorService playListGeneratorService;
	
	@Inject
	public MusicPlayerBean(PlayListGeneratorService playListGeneratorService){
		if(playListGeneratorService == null){
			throw new IllegalArgumentException("PlayListGeneratorService must not be null");
		}
		this.playListGeneratorService = playListGeneratorService;
	}
	
	public MusicPlayerBean(){
		playListGeneratorService = null;
	}

	@Override
	public String getCurrentPlayedSong() {
		return playListGeneratorService.createPlayList();
	}

}
