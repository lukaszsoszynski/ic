package com.impaq.ic.guice.provider.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
