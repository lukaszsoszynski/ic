package com.impaq.ic.cdi.app.ui;


public class UserInterfaceDecorator implements UserInterface {

	private WebUserInterface webUserInterface;

	@Override
	public String getMusic() {
		return webUserInterface.getMusic().toLowerCase();
	}

}
