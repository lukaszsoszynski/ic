package com.impaq.ic.spring.interceptor.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
