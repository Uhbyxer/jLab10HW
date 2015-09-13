package com.epam.lab8.serial;

import java.io.Serializable;

public abstract class Droid implements Serializable {
	protected String name;
	protected int power;
	protected transient int memory;
	
	
	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public Droid(String name) {
		this.name = name;
	}
	
	public abstract void act();
}
