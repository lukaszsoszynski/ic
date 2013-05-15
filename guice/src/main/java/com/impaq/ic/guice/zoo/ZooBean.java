package com.impaq.ic.guice.zoo;

import java.util.List;

public class ZooBean implements ZooService {

	private final List<AnimalService> listAnimal;

	private final PathService pathNormal;

	private final PathService pathExtended;

	private final Person person;

	public ZooBean(List<AnimalService> listAnimal,
			PathService pathNormal, PathService pathExtended,
			Person person) {
		this.listAnimal = listAnimal;
		this.pathNormal = pathNormal;
		this.pathExtended = pathExtended;
		this.person = person;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impaq.ic.guice.zoo.ZooService#longPath()
	 */
	@Override
	public String longPath() {
		List<AnimalService> listAnimalsOnPath = pathExtended
				.getAnimal(listAnimal);
		return showAnimals(listAnimalsOnPath);
	}

	private String showAnimals(List<AnimalService> listAnimalsOnPath) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(person.getPersonName());
		stringBuilder.append(": what a beautifull ");

		boolean first = true;
		for (AnimalService animalService : listAnimalsOnPath) {
			if (!first) {
				stringBuilder.append(" ");
			}
			first = false;
			stringBuilder.append(animalService.getAnimalName());
		}
		return stringBuilder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impaq.ic.guice.zoo.ZooService#shortPath()
	 */
	@Override
	public String shortPath() {
		List<AnimalService> listAnimalsOnPath = pathNormal
				.getAnimal(listAnimal);
		return showAnimals(listAnimalsOnPath);
	}

}
