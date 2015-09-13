package com.epam.tgrynchuk.jewelry.mvc.models;


import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.models.enums.*;

public class Emerald extends PreciousStone {
	private static final Logger LOGGER = Logger.getLogger(Emerald.class);

	public Emerald(int id, String name, StoneColor color, int firmness, Glance glance,
			StoneTransparency transparency, CrystalSystem crystalSystem,
			double refractionIndex, PreciousStoneCategory category,
			double weight) {
		super(id, name, color, firmness, glance, transparency, crystalSystem,
				refractionIndex, category, weight);
		
		LOGGER.trace("Emerald()");
	}

	public Emerald(int id, double value, double weight) {
		super(id, "Смарагд", StoneColor.GREEN, 8, Glance.GLASS, StoneTransparency.SEMITRANSPARENT, 
				CrystalSystem.TRIGONAL,
				1.576, PreciousStoneCategory.FIRST_CATEGORY, weight);
		setValue(value);
		LOGGER.trace("Emerald()");
	}

	@Override
	public String promote(Client client) {
		String res = "";
		
		res = "В давнину смарагд вважали каменем мудрості, холоднокровності і надії.";
		
		if(client.getAge() > 45) 
			res += "Смарагд стабілізує артеріальний тиск, знімає головні і болі в суглобах.";
		
		return res;
	}


}
