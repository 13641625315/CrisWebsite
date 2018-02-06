package com.cris.website.main;

import java.util.ArrayList;
import java.util.Collection;

public class MainTest {

	public static void main(String[] args) {
		Collection<String> liStrings = new ArrayList<>();
		liStrings.add("1");
		liStrings.add("2");
		liStrings.add("3");
		for (String string : liStrings) {
			if ("2".equals(string)) {
				liStrings.remove(string);
			}
		}

		for (String string : liStrings) {
			System.out.println(string);
		}
	}
}
