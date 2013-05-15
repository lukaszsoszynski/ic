package com.impaq.ic.guice.config.bindings.constructor;

import com.impaq.ic.guice.config.database.MusicDatabaseService;
import com.impaq.ic.guice.config.power.PowerStationService;

public class ConstructorBindingBean implements ConstructorBindingService {

	private final MusicDatabaseService musicDatabaseService;

	private final PowerStationService powerStationService;

	/**
	 * Constructor
	 * 
	 * @param musicDatabaseService
	 * @param powerStationService
	 */
	public ConstructorBindingBean(MusicDatabaseService musicDatabaseService,
			PowerStationService powerStationService) {
		this.musicDatabaseService = musicDatabaseService;
		this.powerStationService = powerStationService;
	}

	/**
	 * Constructor
	 * 
	 * @param musicDatabaseService
	 */
	public ConstructorBindingBean(MusicDatabaseService musicDatabaseService) {
		this(musicDatabaseService, null);
	}

	/**
	 * Constructor
	 * 
	 * @param powerStationService
	 */
	public ConstructorBindingBean(PowerStationService powerStationService) {
		this(null, powerStationService);
	}

	/**
	 * Constructor
	 */
	public ConstructorBindingBean() {
		this(null, null);
	}

	/**
	 * Test method
	 * 
	 * @return
	 */
	@Override
	public boolean isCorrectInit() {
		return (musicDatabaseService != null) && (powerStationService != null);
	}

}
