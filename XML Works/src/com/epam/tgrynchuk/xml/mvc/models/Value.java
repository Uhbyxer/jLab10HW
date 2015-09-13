package com.epam.tgrynchuk.xml.mvc.models;

public class Value {
	
	private Integer protein;
	
	private Integer fat;
	
	private Integer carbohydrates;

	public Integer getProtein() {
		return protein;
	}

	public Integer getFat() {
		return fat;
	}

	public Integer getCarbohydrates() {
		return carbohydrates;
	}

	public void setProtein(Integer protein) {
		this.protein = protein;
	}

	public void setFat(Integer fat) {
		this.fat = fat;
	}

	public void setCarbohydrates(Integer carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	@Override
	public String toString() {
		return "Value [P: " + protein + ", F: " + fat
				+ ", C: " + carbohydrates + "]";
	}

	public Value(Integer protein, Integer fat, Integer carbohydrates) {
		super();
		this.protein = protein;
		this.fat = fat;
		this.carbohydrates = carbohydrates;
	}
	
	
	
}
