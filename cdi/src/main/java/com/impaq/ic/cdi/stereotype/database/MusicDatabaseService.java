package com.impaq.ic.cdi.stereotype.database;

import java.util.List;

public interface MusicDatabaseService {

	List<String> getSongs(String gender);
}
