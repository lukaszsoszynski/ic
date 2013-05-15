package com.impaq.ic.cdi.app.ui;

import com.impaq.ic.cdi.app.service.music.MusicService;

public class AndroidUserInterface implements UserInterface {

	private MusicService musicService;

	@Override
	public String getMusic() {
		return "Android player: " + musicService.serveMusic();
	}

}
