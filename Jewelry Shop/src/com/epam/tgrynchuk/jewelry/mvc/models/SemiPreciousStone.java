package com.epam.tgrynchuk.jewelry.mvc.models;

import com.epam.tgrynchuk.jewelry.mvc.models.enums.*;

public abstract class SemiPreciousStone extends Stone {
	
	protected SemiPreciousStoneCategory category;
	
	public SemiPreciousStone(int id, String name, StoneColor color, int firmness,
			Glance glance, StoneTransparency transparency,
			CrystalSystem crystalSystem, double refractionIndex, double weight) {
		super(id, name, color, firmness, glance, transparency, crystalSystem,
				refractionIndex, weight);
	}

	public SemiPreciousStone(int id,String name, StoneColor color, int firmness,
			Glance glance, StoneTransparency transparency,
			CrystalSystem crystalSystem, double refractionIndex,
			SemiPreciousStoneCategory category , double weight) {
		super(id, name, color, firmness, glance, transparency, crystalSystem,
				refractionIndex, weight);
		
		this.category = category;
	}

	public SemiPreciousStoneCategory getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return  "# " + id + ". " + name + "/ Напівкоштовний, " + category 
				+ super.toString();
	}

}