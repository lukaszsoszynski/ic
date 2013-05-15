package com.impaq.ic.guice.named.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
