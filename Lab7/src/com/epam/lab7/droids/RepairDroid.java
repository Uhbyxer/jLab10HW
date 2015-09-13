package com.epam.lab7.droids;

public class RepairDroid extends Droid {

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
