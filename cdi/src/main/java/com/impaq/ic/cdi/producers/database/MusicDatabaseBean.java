package com.impaq.ic.cdi.producers.database;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MusicDatabaseBean implements MusicDatabaseService {

	@Override
	public List<String> getSongs(String gender) {
		if (gender == null) {
			throw new IllegalArgumentException("Unknown music gender");
		}
		List<String> listResult = new ArrayList<String>();
		for (int i = 0; i < 3; ++i) {
			listResult.add(gender + i);
		}
		return listResult;
	}

}
