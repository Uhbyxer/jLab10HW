package com.epam.tgrynchuk.xml.mvc.dto;

import java.util.Collections;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "amount", "candies" })
@XmlRootElement(name = "ingredient")
public class IngredientDTO {
	private String name;
	private Integer amount;
	private CandiesDTO candies = new CandiesDTO();
	
	public IngredientDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public void addCandy(CandyDTO candy) {
		candies.add(candy);
	}
	
	public String getName() {
		return name;
	}
	public Integer getAmount() {
		return amount;
	}
	
	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement( name = "amount" )
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
	public CandiesDTO getCandies() {
		return candies;
	}

	@XmlElement( name = "candies" )
	public void setCandies(CandiesDTO candies) {
		this.candies = candies;
	}

	public IngredientDTO(String name, Integer amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return name + ": " + amount + " { " + candies.toString() + " }\n";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IngredientDTO) {
			return getName().equals(((IngredientDTO) obj).getName());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getName().hashCode();
	}
	
	public static final Comparator<IngredientDTO> BY_NAME = new Comparator<IngredientDTO>() {

		@Override
		public int compare(IngredientDTO first, IngredientDTO second) {
			return first.getName().compareTo(second.getName());
		}
	};

}
