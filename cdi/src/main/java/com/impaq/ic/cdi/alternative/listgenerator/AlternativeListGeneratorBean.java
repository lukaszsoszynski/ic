package com.impaq.ic.cdi.alternative.listgenerator;

import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.impaq.ic.cdi.alternative.database.MusicDatabaseService;

@Alternative
public class AlternativeListGeneratorBean implements PlayListGeneratorService {

	private final MusicDatabaseService musicDatabaseService;

	@Inject
	public AlternativeListGeneratorBean(
			MusicDatabaseService musicDatabaseService) {
		if (musicDatabaseService == null) {
			throw new IllegalArgumentException(
					"MusicDatabaseService must not be null");
		}
		this.musicDatabaseService = musicDatabaseService;
	}

	@Override
	public String createPlayList() {
		List<String> listOfSongs = musicDatabaseService.getSongs("Alternative");
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
