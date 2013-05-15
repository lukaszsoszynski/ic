package com.impaq.ic.guice.interceptor.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
