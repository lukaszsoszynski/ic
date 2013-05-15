package com.impaq.ic.cdi.app.counter;


public class InvocationCounterBean implements InvocationCounterServins {

	private int count;

	public InvocationCounterBean() {
		count = 0;
	}

	@Override
	public void increment() {
		++count;

	}

	@Override
	public int getCount() {
		return count;
	}

}
