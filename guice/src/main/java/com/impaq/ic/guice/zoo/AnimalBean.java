package com.impaq.ic.guice.zoo;

public class AnimalBean implements AnimalService {

	/**
	 * Animal name
	 */
	private final String name;

	public AnimalBean(String name) {
		this.name = name;
	}

	@Override
	public String getAnimalName() {
		return name;
	}

}
