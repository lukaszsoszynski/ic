package com.impaq.ic.cdi.app.ui;

import com.impaq.ic.cdi.app.service.music.MusicService;

public class WebUserInterface implements UserInterface {

	private MusicService musicService;

	public void setMusicService(MusicService musicService) {
		this.musicService = musicService;
	}

	@Override
	public String getMusic() {
		return "Web player " + musicService.serveMusic();
	}

}
