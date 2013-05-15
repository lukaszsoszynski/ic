package com.impaq.ic.guice.inject.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
