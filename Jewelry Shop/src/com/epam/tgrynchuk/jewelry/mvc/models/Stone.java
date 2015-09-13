package com.epam.tgrynchuk.jewelry.mvc.models;

import java.util.Comparator;

import com.epam.tgrynchuk.jewelry.mvc.models.enums.*;

public abstract class Stone implements Valuable, Comparable<Stone> {
	
	protected int id;
	
	protected String name;

	protected StoneColor color;

	protected int firmness;
	
	protected Glance glance;
	
	protected StoneTransparency transparency;

	protected CrystalSystem crystalSystem;
	
	protected double refractionIndex;
	
	protected double value;
	
	protected double weight;
	
	public Stone(int id, String name, StoneColor color, int firmness, Glance glance,
			StoneTransparency transparency, CrystalSystem crystalSystem,
			double refractionIndex, double weight) {
		this.name = name;
		this.color = color;
		this.firmness = firmness;
		this.glance = glance;
		this.transparency = transparency;
		this.crystalSystem = crystalSystem;
		this.refractionIndex = refractionIndex;
		this.weight = weight;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public StoneColor getColor() {
		return color;
	}

	public int getFirmness() {
		return firmness;
	}

	public Glance getGlance() {
		return glance;
	}

	public StoneTransparency getTransparency() {
		return transparency;
	}

	public CrystalSystem getCrystalSystem() {
		return crystalSystem;
	}

	public double getRefractionIndex() {
		return refractionIndex;
	}
	
	@Override
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return  "/ Ціна, $: " + getValue() + "/ Карат: " + getWeight() + "/ " + color + "/ тверд. шк. Мооса: " + firmness + "/ блиск: "
				+ glance + "/ " + transparency
				+ "/ сингонія: " + crystalSystem + "/ інд. залом.: "
				+ refractionIndex;
	}
	
    @Override
    public int compareTo(Stone other) {
    	return getName().compareTo(other.getName());
    }
    
    public static final Comparator<Stone> BY_VALUE_ASC_ORDER = new Comparator<Stone>() {

        @Override
        public int compare(Stone first, Stone second) {
        	return ((Double) first.getValue()).compareTo(second.getValue());
        }
        
    };
    
    public static final Comparator<Stone> BY_VALUE_DESC_ORDER = new Comparator<Stone>() {

        @Override
        public int compare(Stone first, Stone second) {
        	return ((Double) second.getValue()).compareTo(first.getValue());
        }
        
    };
    
    public abstract String promote(Client client);
	
}
