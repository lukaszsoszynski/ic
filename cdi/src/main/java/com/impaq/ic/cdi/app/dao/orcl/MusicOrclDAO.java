package com.impaq.ic.cdi.app.dao.orcl;

import com.impaq.ic.cdi.app.annotation.ds.Music;
import com.impaq.ic.cdi.app.dao.MusicDAO;
import com.impaq.ic.cdi.app.ds.Connection;
import com.impaq.ic.cdi.app.ds.DataSource;

public class MusicOrclDAO implements MusicDAO {

	private final DataSource orclMusicDataSource;

	public MusicOrclDAO(@Music DataSource orclMusicDataSource) {
		this.orclMusicDataSource = orclMusicDataSource;
	}

	@Override
	public String getById(long id) {
		String name = getDsName();
		return "Music " + id + " from " + name;
	}

	private String getDsName() {
		Connection connection = orclMusicDataSource.getConnection();
		String name = connection.getName();
		return name;
	}

	@Override
	public String getMusicByTrackName(String name) {
		String dsName = getDsName();
		return name + " from " + dsName;
	}

}
