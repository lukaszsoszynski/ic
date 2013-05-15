package com.impaq.ic.cdi.app.ds;

class OrclDataSource implements DataSource {

	private final String connectionString;

	public OrclDataSource(String connectionString) {
		this.connectionString = connectionString;
	}

	@Override
	public Connection getConnection() {
		return new Connection("Orcl: " + connectionString);
	}

}
