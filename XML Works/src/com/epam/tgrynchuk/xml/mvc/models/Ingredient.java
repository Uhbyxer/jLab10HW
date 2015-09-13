package com.epam.tgrynchuk.xml.mvc.models;

public class Ingredient {
	private String name;

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Ingredient(String name) {
		super();
		this.name = name;
	}
	
	public Ingredient() {
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Ingredient) {
			return toString().equals(obj.toString());
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
