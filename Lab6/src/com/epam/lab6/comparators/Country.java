package com.epam.lab6.comparators;

import java.util.Comparator;

public class Country implements Comparable<Country> {
	private String name;
	private String capital;
	
	public Country(String name, String capital) {
		super();
		this.name = name;
		this.capital = capital;
	}

	public String getName() {
		return name;
	}

	public String getCapital() {
		return capital;
	}

	@Override
	public String toString() {
		return name + " ["+ capital + "]";
	}

	@Override
	public int compareTo(Country other) {
		return getName().compareTo(other.getName());
	}
	
	public static final Comparator<Country> BY_CAPITAL_ORDER = new Comparator<Country>() {

		@Override
		public int compare(Country first, Country second) {
			return first.getCapital().compareTo(second.getCapital());
		}
		
	};
}
