package com.impaq.ic.cdi.search.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
