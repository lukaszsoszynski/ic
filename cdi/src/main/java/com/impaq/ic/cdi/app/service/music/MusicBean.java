package com.impaq.ic.cdi.app.service.music;

import com.impaq.ic.cdi.app.dao.MusicDAO;
import com.impaq.ic.cdi.app.service.aaa.AAAService;
import com.impaq.ic.cdi.app.service.billing.BillingService;

public class MusicBean implements MusicService {

	private final AAAService aaaService;

	private final BillingService billingService;

	private final MusicDAO musicDAO;

	public MusicBean(AAAService aaaService, BillingService billingService,
			MusicDAO musicDAO) {
		super();
		this.aaaService = aaaService;
		this.billingService = billingService;
		this.musicDAO = musicDAO;
	}

	@Override
	public String serveMusic() {

		String user = aaaService.getUser();
		return musicDAO.getMusicByTrackName("Nice music") + " for " + user
				+ " cost " + billingService.getBill(user);
	}

}
