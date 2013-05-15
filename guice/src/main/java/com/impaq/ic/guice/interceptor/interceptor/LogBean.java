package com.impaq.ic.guice.interceptor.interceptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Singleton;

@Singleton
public class LogBean {

	private final List<String> listLogs;

	public LogBean() {
		this.listLogs = new ArrayList<String>();
	}

	public void append(String entry) {
		listLogs.add(entry);
	}

	public List<String> getLogs() {
		return Collections.unmodifiableList(listLogs);
	}

}
