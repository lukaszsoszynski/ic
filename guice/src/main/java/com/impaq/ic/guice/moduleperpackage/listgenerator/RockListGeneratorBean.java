package com.impaq.ic.guice.moduleperpackage.listgenerator;

import java.util.List;

import javax.inject.Inject;

import com.impaq.ic.guice.moduleperpackage.database.MusicDatabaseService;
import com.impaq.ic.guice.moduleperpackage.qualifier.Rock;

@Rock
class RockListGeneratorBean implements PlayListGeneratorService {

	private final MusicDatabaseService musicDatabaseService;

	@Inject
	RockListGeneratorBean(MusicDatabaseService musicDatabaseService) {
		if (musicDatabaseService == null) {
			throw new IllegalArgumentException(
					"MusicDatabaseService must not be null");
		}
		this.musicDatabaseService = musicDatabaseService;
	}

	@Override
	public String createPlayList() {
		List<String> listOfSongs = musicDatabaseService.getSongs("Rock");
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
