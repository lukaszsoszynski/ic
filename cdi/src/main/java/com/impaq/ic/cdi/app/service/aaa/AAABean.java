package com.impaq.ic.cdi.app.service.aaa;

import com.impaq.ic.cdi.app.dao.UserDAO;

public class AAABean implements AAAService {

	private final UserDAO userDAO;

	public AAABean(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public String getUser() {
		return userDAO.getById(7);
	}
}
