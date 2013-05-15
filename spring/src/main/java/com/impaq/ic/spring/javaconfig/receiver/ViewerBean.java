package com.impaq.ic.spring.javaconfig.receiver;

public class ViewerBean implements ViewerService {

	private final TvSetService tvSetService;

	public ViewerBean(TvSetService tvSetService) {
		this.tvSetService = tvSetService;
	}

	@Override
	public String view() {
		return "viewer: " + tvSetService.display();
	}

}
