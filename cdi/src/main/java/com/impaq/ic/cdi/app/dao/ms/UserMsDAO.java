package com.impaq.ic.cdi.app.dao.ms;

import com.impaq.ic.cdi.app.annotation.ds.MS;
import com.impaq.ic.cdi.app.dao.UserDAO;
import com.impaq.ic.cdi.app.ds.DataSource;

public class UserMsDAO implements UserDAO {

	private final DataSource msDataSource;

	public UserMsDAO(@MS DataSource msDataSource) {
		this.msDataSource = msDataSource;
	}

	@Override
	public String getById(long id) {
		return "User " + id + " from " + msDataSource.getConnection().getName();
	}

}
