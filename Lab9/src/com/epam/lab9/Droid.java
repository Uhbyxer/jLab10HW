package com.epam.lab9;

import java.io.Serializable;

import com.epam.lab9.annot.DroidField;


public  class Droid implements Serializable {
	@DroidField(imutable = true)
	protected String name;
	@DroidField(imutable = false)
	protected int power;
	protected transient int memory;
	@DroidField(imutable = true)
	private String secondName;
	
	public int getPower() {
		System.out.println("getPower: " + power);
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
		System.out.println("setPower: " + power);
	}

	public int getMemory() {
		System.out.println("getMemory: " + memory);
		return memory;
		
	}

	public void setMemory(int memory) {
		this.memory = memory;
		System.out.println("setMemory: " + memory);
	}

	public Droid(String name) {
		this.name = name;
	}
	
	public Droid() {
	}
	
	public void act() {
		System.out.println("Doing some action ...");
	}
	
	public void act(String[] str) {
		System.out.println("!!!!! Doing some action ...");
	}	
	public void setFriends(String...strings) {
		for(String s: strings) {
			System.out.println("set fiend " + s);
		}
	}
	
	public void setEnemies(String s,int...ints) {
		System.out.println("setEnemies(String s,int...ints)");
		System.out.println("s = " + s);
	}	
	
}
