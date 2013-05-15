package com.impaq.ic.cdi.event.power;

public interface PowerStationService {

	boolean isPowerOn();

	void prepareBlackout(int minuts);

	public abstract void withdrawBlackout();

}
