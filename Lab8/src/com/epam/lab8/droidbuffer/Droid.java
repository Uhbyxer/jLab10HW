package com.epam.lab8.droidbuffer;

import java.io.Serializable;

public class Droid {
	protected String name;
	protected int id;
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

	@Override
	public String toString() {
		return "Droid [id=" + id + "]";
	}

	public Droid(int id) {
		super();
		this.id = id;
	}
	
	
	
}