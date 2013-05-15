package com.impaq.ic.cdi.producers.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
