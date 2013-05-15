package com.impaq.ic.guice.config.listgenerator;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.impaq.ic.guice.config.database.MusicDatabaseService;
import com.impaq.ic.guice.config.qualifier.Pop;

@Pop
public class PopListGeneratorBean implements PlayListGeneratorService {

	private final MusicDatabaseService musicDatabaseService;
	private final String gender;

	@Inject
	public PopListGeneratorBean(MusicDatabaseService musicDatabaseService,
			@Named("music") String gender) {
		if (musicDatabaseService == null) {
			throw new IllegalArgumentException(
					"MusicDatabaseService must not be null");
		}
		this.musicDatabaseService = musicDatabaseService;
		this.gender = gender;
	}

	@Override
	public String createPlayList() {
		List<String> listOfSongs = musicDatabaseService.getSongs(gender);
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
