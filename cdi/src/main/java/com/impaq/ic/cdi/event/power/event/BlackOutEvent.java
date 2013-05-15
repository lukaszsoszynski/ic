package com.impaq.ic.cdi.event.power.event;

public class BlackOutEvent {

	private final int minutsToBlackout;

	public BlackOutEvent(int minutsToBlackout) {
		this.minutsToBlackout = minutsToBlackout;
	}

	public int getMinutsToBlackout() {
		return minutsToBlackout;
	}

}
