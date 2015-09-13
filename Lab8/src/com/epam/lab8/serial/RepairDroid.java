package com.epam.lab8.serial;

import java.io.Serializable;

public class RepairDroid extends Droid implements Serializable {

	public RepairDroid(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		return "RepairDroid " + name;
	}
	
	public void repair() {
		System.out.println("\tRepairing...");
	}

	@Override
	public void act() {
		repair();
		
	}
}
