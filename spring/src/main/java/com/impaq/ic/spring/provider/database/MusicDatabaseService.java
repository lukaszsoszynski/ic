package com.impaq.ic.spring.provider.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
