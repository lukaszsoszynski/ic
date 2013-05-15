package com.impaq.ic.guice.config.listgenerator;

import javax.inject.Inject;
import javax.inject.Named;

import com.impaq.ic.guice.config.qualifier.Pop;

/**
 * Setter/field injection example
 * 
 * @author Lukasz
 * 
 */
public class PlayListMixerBean implements PlayListGeneratorService {

	private PlayListGeneratorService rockPlayListGeneratorService;

	/**
	 * Field injection
	 */
	@Inject
	@Pop
	private PlayListGeneratorService popPlayListGeneratorService;

	/**
	 * Setter injection
	 * 
	 * @param rockPlayListGeneratorService
	 */
	@Inject
	public void setRockPlayListGeneratorService(
			@Named("Rock") PlayListGeneratorService rockPlayListGeneratorService) {
		this.rockPlayListGeneratorService = rockPlayListGeneratorService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String createPlayList() {
		return rockPlayListGeneratorService.createPlayList() + " "
				+ popPlayListGeneratorService.createPlayList();
	}

}
