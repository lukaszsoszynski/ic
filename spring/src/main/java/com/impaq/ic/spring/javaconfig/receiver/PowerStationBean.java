package com.impaq.ic.spring.javaconfig.receiver;

public class PowerStationBean implements PowerStationService {

	static boolean on = false;

	public PowerStationBean() {
		on = true;
	}

	@Override
	public boolean isPowerOn() {
		return on;
	}

}
