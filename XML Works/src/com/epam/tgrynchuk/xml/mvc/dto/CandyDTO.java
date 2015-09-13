package com.epam.tgrynchuk.xml.mvc.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.epam.tgrynchuk.xml.mvc.models.Candy;
import com.epam.tgrynchuk.xml.mvc.models.Ingredient;
import com.epam.tgrynchuk.xml.utils.Setter;

@XmlType(propOrder = { "id", "name", "energy", "type", "value",  "production" })
@XmlRootElement(name = "candy")
public class CandyDTO {
	
	private Integer id;
	
	private String name;
	
	private Integer energy;
	
	private String type;
	
	private String production;
	
	private ValueDTO value;
	
	
	@XmlElement(name = "id")
	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "energy")
	public void setEnergy(Integer energy) {
		this.energy = energy;
	}

	@XmlElement(name = "type")
	public void setType(String type) {
		this.type = type;
	}

	@XmlElement(name = "production")
	public void setProduction(String production) {
		this.production = production;
	}
	
	@XmlElement(name = "value")
	public void setValue(ValueDTO value) {
		this.value = value;
	}
	


	@Override
	public String toString() {
		
		return name + " ( id=" + id + "/ energy: " + energy
				+ "/ type: " + type + "/ production: " + production + "/ " + value + ") " 
				;
	}
	
	public CandyDTO(Candy candy) {
		setId(candy.getId());
		setName(candy.getName());
		setEnergy(candy.getEnergy());
		setProduction(candy.getProduction());
		setValue(new ValueDTO(candy.getValue()));
	}
	
	public CandyDTO() {
		// TODO Auto-generated constructor stub
	}	
	
	@Override
	public int hashCode() {
		return getId().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof CandyDTO) {
			return getId().equals( ((CandyDTO) obj).getId()  );
		}
		
		return false;
	}
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getEnergy() {
		return energy;
	}

	public String getType() {
		return type;
	}

	public String getProduction() {
		return production;
	}

	
	public ValueDTO getValue() {
		return value;
	}
}
