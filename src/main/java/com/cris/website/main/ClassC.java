package com.cris.website.main;

public class ClassC extends ClassP {
	public String myDoObtain() {
		return super.obtainUsername();
	}

	@Override
	protected String obtainUsername() {
		return "C";
	}
}
