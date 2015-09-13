package com.epam.lab7.droids;

public class FlyBattleDroid extends BattleDroid implements CanFly {

	public FlyBattleDroid(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		return "FlyBattleDroid " + name;
	}

	@Override
	public void fly() {
		System.out.println("\tFlying with blaster...");
		
	}
	
	@Override
	public void act() {
		fly();
		super.act();
	}
	
}
