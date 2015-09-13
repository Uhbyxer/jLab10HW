package com.epam.lab8.serial;

import java.io.Serializable;

public class BattleDroid extends Droid implements Serializable {

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
