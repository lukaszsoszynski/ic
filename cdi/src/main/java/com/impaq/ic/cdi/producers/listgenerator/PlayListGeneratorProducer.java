package com.impaq.ic.cdi.producers.listgenerator;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import com.impaq.ic.cdi.producers.database.MusicDatabaseService;
import com.impaq.ic.cdi.producers.qualifier.Pop;
import com.impaq.ic.cdi.producers.qualifier.Rock;

public class PlayListGeneratorProducer {

	/**
	 * Field producer
	 */
	@Produces
	@Pop
	private String pop = "Pop";

	/**
	 * Field producer
	 */
	@Produces
	@Rock
	private String rock = "Rock";

	/**
	 * Method producer
	 * 
	 * @param musicDatabaseService
	 * @param type
	 * @return
	 */
	@Produces
	@Pop
	public PlayListGeneratorService popMusicPlayerService(
			MusicDatabaseService musicDatabaseService, @Pop String type) {
		return new PlayListGeneratorBean(musicDatabaseService, type);
	}

	/**
	 * Method producer
	 * 
	 * @param musicDatabaseService
	 * @param type
	 * @return
	 */
	@Produces
	@Rock
	public PlayListGeneratorService rockMusicPlayerService(
			MusicDatabaseService musicDatabaseService, @Rock String type,
			InjectionPoint injectionPoint) {
		String injectedTo = injectionPoint.getBean().getBeanClass()
				.getCanonicalName();
		System.out.println("PlayListGeneratorBean injected to " + injectedTo);
		return new PlayListGeneratorBean(musicDatabaseService, type);
	}

}
