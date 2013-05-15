package com.impaq.ic.spring.named.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
