package com.impaq.ic.cdi.app.ds;


public class OrclDataSourceProducer {

	public DataSource getMusicDataSource() {
		return new OrclDataSource("music");
	}

	public DataSource getBillingDataSource() {
		return new OrclDataSource("biling");
	}

}
