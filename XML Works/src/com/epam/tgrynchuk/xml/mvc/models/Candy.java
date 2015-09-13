package com.epam.tgrynchuk.xml.mvc.models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import com.epam.tgrynchuk.xml.utils.Setter;

@SuppressWarnings("serial")
public class Candy extends HashMap<Ingredient, Integer> {
	private Integer id;
	
	private String name;
	
	private Integer energy;
	
	private String type;
	
	private String production;
	
	private Value value;
	
	//intgredients
	
	public Candy() {
	}
	
	public Candy(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		
		StringJoiner joiner = new StringJoiner(", ");
		for(Map.Entry<Ingredient, Integer>  entry: entrySet()) {
			joiner.add(entry.getKey() + ": " + entry.getValue());
		}
		
		return name + " ( id=" + id + "/ energy: " + energy
				+ "/ type: " + type + "/ production: " + production + "/ " + value + ") " 
				+ "\nIngr. { " + joiner.toString() + "}";
		
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

	@Setter("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@Setter("name")
	public void setName(String name) {
		this.name = name;
	}

	@Setter("energy")
	public void setEnergy(Integer energy) {
		this.energy = energy;
	}

	@Setter("type")
	public void setType(String type) {
		this.type = type;
	}

	@Setter("production")
	public void setProduction(String production) {
		this.production = production;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}
	
	public void setValue(Integer protein, Integer fat, Integer carbohydrates) {
		this.value = new Value(protein, fat, carbohydrates);
	}
	
	@Override
	public Integer put(Ingredient key, Integer value) {
		
		Integer oldValue = getOrDefault(key, 0);
		
		return super.put(key, value + oldValue);
	}
	
	public Integer put(String key, Integer value) {
		return put(new Ingredient(key), value);
	}
	
	public static final Comparator<Candy> BY_NAME =
			(first, second) -> {
				return first.getName().compareTo(second.getName());
			};
}
