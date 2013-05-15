package com.impaq.ic.spring.qualifier.listgenerator;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.impaq.ic.spring.qualifier.database.MusicDatabaseService;
import com.impaq.ic.spring.qualifier.qualifier.Rock;

@Named
@Rock
public class RockListGeneratorBean implements PlayListGeneratorService {

	private final MusicDatabaseService musicDatabaseService;

	@Inject
	public RockListGeneratorBean(MusicDatabaseService musicDatabaseService) {
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