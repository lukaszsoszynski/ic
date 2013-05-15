package com.impaq.ic.cdi.interceptor.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
