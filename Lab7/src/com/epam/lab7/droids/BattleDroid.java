package com.epam.lab7.droids;

public class BattleDroid extends Droid {

	public BattleDroid(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		return "BattleDroid " + name;
	}
	
	public void shoot() {
		System.out.println("\tShooting...");
	}

	@Override
	public void act() {
		shoot();
	}
}
