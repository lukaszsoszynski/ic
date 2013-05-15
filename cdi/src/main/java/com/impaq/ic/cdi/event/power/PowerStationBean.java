package com.impaq.ic.cdi.event.power;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import com.impaq.ic.cdi.event.power.event.BlackOutEvent;
import com.impaq.ic.cdi.event.power.event.Expected;
import com.impaq.ic.cdi.event.power.event.Withdraw;

@ApplicationScoped
public class PowerStationBean implements PowerStationService {

	@Inject
	private Event<BlackOutEvent> event;

	@Inject
	@Withdraw
	private Event<BlackOutEvent> eventWithdraw;

	public PowerStationBean() {
	}

	@Override
	public boolean isPowerOn() {
		return true;
	}

	@SuppressWarnings("serial")
	@Override
	public void prepareBlackout(int minuts) {
		BlackOutEvent blackOutEvent = new BlackOutEvent(minuts);
		event.select(new AnnotationLiteral<Expected>() {
		}).fire(blackOutEvent);
	}

	@Override
	public void withdrawBlackout() {
		BlackOutEvent blackOutEvent = new BlackOutEvent(0);
		eventWithdraw.fire(blackOutEvent);
	}

}
