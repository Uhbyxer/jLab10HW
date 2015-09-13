package com.epam.tgrynchuk.jewelry.mvc.models;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.models.enums.*;

public class Topaz extends PreciousStone {
	private static final Logger LOGGER = Logger.getLogger(Topaz.class);

	public Topaz(int id, String name, StoneColor color, int firmness, Glance glance,
			StoneTransparency transparency, CrystalSystem crystalSystem,
			double refractionIndex, PreciousStoneCategory category,
			double weight) {
		super(id, name, color, firmness, glance, transparency, crystalSystem,
				refractionIndex, category, weight);
		
		LOGGER.trace(getClass().getSimpleName());
	}
	
	public Topaz(int id, double value, double weight) {
		super(id, "Топаз", StoneColor.BLUE, 7, Glance.GLASS, StoneTransparency.SEMITRANSPARENT, 
				CrystalSystem.HEXAGONAL,
				1.384, PreciousStoneCategory.FIRST_CATEGORY, weight);
		setValue(value);
		
		LOGGER.trace(getClass().getSimpleName());
	}

	@Override
	public String promote(Client client) {
		String res = "";
		
		res = "У стародавньому світі топаз вважали каменем, який здатний викривати таємниці.";
		
		if(!client.isMale()) 
			res += "Жінка завжди буде знати всі секрети свого обранця.";
		
		return res;
	}
}
