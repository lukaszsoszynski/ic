package com.impaq.ic.guice.moduleperpackage.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
