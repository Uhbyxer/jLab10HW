package com.epam.lab7.droidqueue;

import java.util.Comparator;

public class Droid {
	protected String name;
	protected Integer power;
	protected Integer health;
	
	
	
	public String getName() {
		return name;
	}

	public Integer getPower() {
		return power;
	}


	public Integer getHealth() {
		return health;
	}

	public Droid(String name, Integer power, Integer health) {
		this.name = name;
		this.power = power;
		this.health = health;
	}


	@Override
	public String toString() {
		return "Droid [name=" + name + ", power=" + power + ", health="
				+ health + "]";
	}
	
	public static final Comparator<Droid> BY_POWER_AND_HEALTH = new Comparator<Droid>() {

		@Override
		public int compare(Droid first, Droid second) {
			int res = second.getPower().compareTo(first.getPower());
			if(res == 0)
				res = second.getHealth().compareTo(first.getHealth());
			return res;
		}
		
	};
	
	public static final Comparator<Droid> BY_NAME = new Comparator<Droid>() {

		@Override
		public int compare(Droid first, Droid second) {
			return first.getName().compareTo(second.getName());
		}
		
	};}
