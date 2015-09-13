package com.epam.lab7.droidqueue;

public class BattleDroid extends Droid {

	public BattleDroid(String name, Integer power, Integer health) {
		super(name, power, health);
	}

	@Override
	public String toString() {
		return "Battle " + super.toString();
	}
	
	public void fight() {
		
	}
	
}
