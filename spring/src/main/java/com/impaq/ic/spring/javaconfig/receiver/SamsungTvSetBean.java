package com.impaq.ic.spring.javaconfig.receiver;

import com.impaq.ic.spring.javaconfig.tv.TelevisionService;

public class SamsungTvSetBean implements TvSetService {

	private final TelevisionService tvService;

	/**
	 * Constructor
	 * 
	 * @param tvService
	 */
	public SamsungTvSetBean(TelevisionService tvService) {
		if (tvService == null) {
			throw new IllegalArgumentException("tvService must not be null");
		}
		this.tvService = tvService;
	}

	@Override
	public String display() {
		return "Samsung" + tvService.getNews();
	}

}
