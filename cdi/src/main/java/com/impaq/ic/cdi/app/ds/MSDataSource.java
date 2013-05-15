package com.impaq.ic.cdi.app.ds;


public class MSDataSource implements DataSource {

	@Override
	public Connection getConnection() {
		return new Connection("M$");
	}

}
