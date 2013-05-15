package com.impaq.ic.guice.zoo;

import java.util.List;

public class LongPathBean implements PathService {

	@Override
	public List<AnimalService> getAnimal(List<AnimalService> list) {
		return list;
	}

}
