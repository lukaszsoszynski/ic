package com.impaq.ic.cdi.decorator.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
