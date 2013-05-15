package com.impaq.ic.cdi.search.player;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import com.impaq.ic.cdi.search.listgenerator.PlayListGeneratorService;
import com.impaq.ic.cdi.search.qualifiers.Pop;
import com.impaq.ic.cdi.search.qualifiers.Rock;

public class MusicPlayerBean implements MusicPlayerService {

	private final Instance<PlayListGeneratorService> instance;

	/**
	 * @Any - extremely important
	 * @param playListGeneratorService
	 */
	@Inject
	public MusicPlayerBean(
			@Any Instance<PlayListGeneratorService> playListGeneratorService) {
		if (playListGeneratorService == null) {
			throw new IllegalArgumentException(
					"PlayListGeneratorService must not be null");
		}
		this.instance = playListGeneratorService;
	}

	public MusicPlayerBean() {
		instance = null;
	}

	@Override
	public String getPopPlayedSong() {
		@SuppressWarnings("serial")
		PlayListGeneratorService service = instance.select(
				new AnnotationLiteral<Pop>() {
				}).get();
		return service.createPlayList();
	}

	@Override
	public String getRockPlayedSong() {
		@SuppressWarnings("serial")
		PlayListGeneratorService service = instance.select(
				new AnnotationLiteral<Rock>() {
				}).get();
		return service.createPlayList();
	}

	@Override
	public String getPlayedSong(String type) {
		
		//szukanie po adnotacji i jej atrybucie
		PlayListGeneratorService service = instance.select(
				new NameAnnotationLiteral(type)).get();
		return service.createPlayList();
	}
}
