package com.epam.tgrynchuk.xml.mvc.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.epam.tgrynchuk.xml.mvc.models.Value;

@XmlType(propOrder = { "protein", "fat", "carbohydrates"})
@XmlRootElement(name = "value")
public class ValueDTO {
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
	
	@XmlElement(name = "protein")
	public void setProtein(Integer protein) {
		this.protein = protein;
	}

	@XmlElement(name = "fat")
	public void setFat(Integer fat) {
		this.fat = fat;
	}

	@XmlElement(name = "carbohydrates")
	public void setCarbohydrates(Integer carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	@Override
	public String toString() {
		return "Value [P: " + protein + ", F: " + fat
				+ ", C: " + carbohydrates + "]";
	}

	public ValueDTO(Integer protein, Integer fat, Integer carbohydrates) {
		super();
		this.protein = protein;
		this.fat = fat;
		this.carbohydrates = carbohydrates;
	}
	
	public ValueDTO(Value value) {
		super();
		this.protein = value.getProtein();
		this.fat = value.getFat();
		this.carbohydrates = value.getCarbohydrates();
	}
	
	public ValueDTO() {
		// TODO Auto-generated constructor stub
	}
}
