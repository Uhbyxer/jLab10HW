package com.epam.lab7.droids;

public abstract class Droid {
	protected String name;
	
	public Droid(String name) {
		this.name = name;
	}
	
	public abstract void act();
}
