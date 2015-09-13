package com.epam.tgrynchuk.jewelry.mvc.models;

import com.epam.tgrynchuk.jewelry.mvc.models.enums.*;

public abstract class PreciousStone extends Stone {
	
	protected PreciousStoneCategory category;
	
	public PreciousStone(int id, String name, StoneColor color, int firmness,
			Glance glance, StoneTransparency transparency,
			CrystalSystem crystalSystem, double refractionIndex, double weight) {
		super(id, name, color, firmness, glance, transparency, crystalSystem,
				refractionIndex, weight);
	}

	public PreciousStone(int id,String name, StoneColor color, int firmness,
			Glance glance, StoneTransparency transparency,
			CrystalSystem crystalSystem, double refractionIndex,
			PreciousStoneCategory category, double weight) {
		super(id, name, color, firmness, glance, transparency, crystalSystem,
				refractionIndex, weight);
		
		this.category = category;
	}

	public PreciousStoneCategory getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return  "# " + id + ". " + name + "/ Коштовний, " + category 
				+ super.toString();
	}

}
