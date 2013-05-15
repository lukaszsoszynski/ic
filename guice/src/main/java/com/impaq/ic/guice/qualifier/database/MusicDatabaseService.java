package com.impaq.ic.guice.qualifier.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
