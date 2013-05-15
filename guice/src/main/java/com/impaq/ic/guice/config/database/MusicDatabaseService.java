package com.impaq.ic.guice.config.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
