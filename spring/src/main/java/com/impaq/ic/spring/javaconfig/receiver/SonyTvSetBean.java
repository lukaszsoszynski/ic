package com.impaq.ic.spring.javaconfig.receiver;

import com.impaq.ic.spring.javaconfig.tv.TelevisionService;

public class SonyTvSetBean implements TvSetService {

	private final TelevisionService televisionService;

	public SonyTvSetBean(TelevisionService televisionService) {
		this.televisionService = televisionService;
	}

	@Override
	public String display() {
		if (!PowerStationBean.on) {
			throw new IllegalStateException("Blackout...");
		}
		return "sony: " + televisionService.getNews();
	}

}
