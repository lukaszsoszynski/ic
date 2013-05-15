package com.impaq.ic.cdi.decorator.listgenerator;

import java.util.Arrays;
import java.util.Collections;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class RandomListGeneratorDecorator implements PlayListGeneratorService {

	@Inject
	@Delegate
	private com.impaq.ic.cdi.decorator.listgenerator.PlayListGeneratorService playListGeneratorService;

	@Override
	public String createPlayList() {
		// return "Rock2 Rock1 Rock0";
		String playList = playListGeneratorService.createPlayList();
		String[] songs = playList.split(" ");
		Collections.shuffle(Arrays.asList(songs));
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < songs.length; ++i) {
			if (i != 0) {
				stringBuilder.append(" ");
			}
			stringBuilder.append(songs[i]);
		}
		return stringBuilder.toString();
	}

}
