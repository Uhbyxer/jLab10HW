package com.epam.tgrynchuk.jewelry.mvc.models;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.models.enums.*;

public class Beryl extends PreciousStone {
	private static final Logger LOGGER = Logger.getLogger(Beryl.class);

	public Beryl(int id, String name, StoneColor color, int firmness, Glance glance,
			StoneTransparency transparency, CrystalSystem crystalSystem,
			double refractionIndex, PreciousStoneCategory category,
			double weight) {
		super(id, name, color, firmness, glance, transparency, crystalSystem,
				refractionIndex, category, weight);
		
		LOGGER.trace("Beryl()");
	}
	
	public Beryl(int id, double value, double weight) {
		super(id, "Берил", StoneColor.STRAW, 7, Glance.MAT, StoneTransparency.TRANSTLUCENT, 
				CrystalSystem.CUBIC,
				1.568, PreciousStoneCategory.THIRD_CATEGORY, weight);
		setValue(value);
		
		LOGGER.trace("Beryl()");
	}

	@Override
	public String promote(Client client) {
		String res = "";
		
		res = "Берил - оберігач сімейного вогнища, добрих взаємин між батьками і дітьми.";
		
		if(!client.isMale()) 
			res += "У давнину за допомогою берилу виліковували безліч жіночих захворювань.";
		
		return res;
	}

}
