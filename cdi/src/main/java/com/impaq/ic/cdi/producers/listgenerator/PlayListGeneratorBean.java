package com.impaq.ic.cdi.producers.listgenerator;

import java.util.List;

import com.impaq.ic.cdi.producers.database.MusicDatabaseService;

public class PlayListGeneratorBean implements PlayListGeneratorService {

	private final String musicType;

	private final MusicDatabaseService musicDatabaseService;

	PlayListGeneratorBean(MusicDatabaseService musicDatabaseService,
			String musicType) {
		if (musicDatabaseService == null) {
			throw new IllegalArgumentException(
					"MusicDatabaseService must not be null");
		}
		if (musicType == null) {
			throw new IllegalArgumentException("Music type must not be null");
		}
		this.musicDatabaseService = musicDatabaseService;
		this.musicType = musicType;
	}

	@Override
	public String createPlayList() {
		List<String> listOfSongs = musicDatabaseService.getSongs(musicType);
		StringBuilder stringBuilder = new StringBuilder();
		boolean first = true;
		for (String i : listOfSongs) {
			if (!first) {
				stringBuilder.append(" ");
			}
			first = false;
			stringBuilder.append(i);
		}
		return stringBuilder.toString();
	}
}
