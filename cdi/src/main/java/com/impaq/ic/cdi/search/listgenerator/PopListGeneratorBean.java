package com.impaq.ic.cdi.search.listgenerator;

import java.util.List;

import javax.inject.Inject;

import com.impaq.ic.cdi.search.database.MusicDatabaseService;
import com.impaq.ic.cdi.search.qualifiers.Pop;

@Pop
public class PopListGeneratorBean implements PlayListGeneratorService {

	private final MusicDatabaseService musicDatabaseService;

	@Inject
	public PopListGeneratorBean(MusicDatabaseService musicDatabaseService) {
		if (musicDatabaseService == null) {
			throw new IllegalArgumentException(
					"MusicDatabaseService must not be null");
		}
		this.musicDatabaseService = musicDatabaseService;
	}

	@Override
	public String createPlayList() {
		List<String> listOfSongs = musicDatabaseService.getSongs("Pop");
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
