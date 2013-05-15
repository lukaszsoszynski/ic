package com.impaq.ic.guice.zoo;

import java.util.ArrayList;
import java.util.List;

public class ShortPathBean implements PathService {

	@Override
	public List<AnimalService> getAnimal(List<AnimalService> list) {
		List<AnimalService> listResult = new ArrayList<AnimalService>();
		for (int i = 0; i < list.size(); i += 2) {
			listResult.add(list.get(i));
		}
		return listResult;
	}

}
