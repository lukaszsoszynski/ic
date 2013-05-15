package com.impaq.ic.cdi.provider.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
