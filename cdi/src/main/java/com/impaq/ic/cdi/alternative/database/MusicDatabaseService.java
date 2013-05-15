package com.impaq.ic.cdi.alternative.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
