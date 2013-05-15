package com.impaq.ic.cdi.event.player;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

import com.impaq.ic.cdi.event.power.event.BlackOutEvent;
import com.impaq.ic.cdi.event.power.event.Expected;
import com.impaq.ic.cdi.event.power.event.Withdraw;

@ApplicationScoped
public class MusicPlayerBean implements MusicPlayerService {

	private boolean blackoutExpected;
	private int minuts;

	public MusicPlayerBean() {
		this.blackoutExpected = false;
	}

	@Override
	public String getCurrentPlayedSong() {
		if (blackoutExpected) {
			return "Blackout expected in " + minuts + " minuts.";
		}
		return "Rock0 Rock1 Rock2";
	}

	public void onBlackoutExpected(
			@Observes @Expected BlackOutEvent blackOutEvent) {
		blackoutExpected = true;
		minuts = blackOutEvent.getMinutsToBlackout();
	}

	public void onBlackoutWithdraw(
			@Observes(during = TransactionPhase.IN_PROGRESS) @Withdraw BlackOutEvent blackOutEvent) {
		blackoutExpected = false;
		minuts = 0;
	}

}
