package com.epam.lab7.droids;

public class FlyRepairDroid extends RepairDroid implements CanFly {

	public FlyRepairDroid(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		return "FlyRepairDroid " + name;
	}

	@Override
	public void fly() {
		System.out.println("\tFlying with some repair stuff...");
		
	}
	
	@Override
	public void act() {
		fly();
		super.act();
	}
}
