package com.epam.tgrynchuk.jewelry.mvc.models;

import org.apache.log4j.Logger;

public class Client {
	private static final Logger LOGGER = Logger.getLogger(Client.class);
	
	private String name;
	
	private int age;
	
	private boolean male;
	
	public Client(String name, int age, boolean male) {
		super();
		this.name = name;
		this.age = age;
		this.male = male;
		
		LOGGER.trace("Client()");
	}

	@Override
	public String toString() {
		return name + " (" + (male ? "чоловік, " : "жінка, ") +
				+ age + " років)";
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean isMale() {
		return male;
	}
	
}
