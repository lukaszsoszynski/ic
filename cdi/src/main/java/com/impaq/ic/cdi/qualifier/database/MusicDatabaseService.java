package com.impaq.ic.cdi.qualifier.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
