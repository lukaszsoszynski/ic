package com.impaq.ic.cdi.app.ds;

public class Connection {

	private final String name;

	public Connection(String name) {
		this.name = name;
	}

	public void close() {

	}

	public String getName() {
		return name;
	}

}
