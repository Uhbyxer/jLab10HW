package com.epam.tgrynchuk.jewelry.mvc.models;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.models.enums.*;

public class Agate extends SemiPreciousStone {
	private static final Logger LOGGER = Logger.getLogger(Agate.class);

	public Agate(int id, String name, StoneColor color, int firmness, Glance glance,
			StoneTransparency transparency, CrystalSystem crystalSystem,
			double refractionIndex, SemiPreciousStoneCategory category,
			double weight) {
		super(id, name, color, firmness, glance, transparency, crystalSystem,
				refractionIndex, category, weight);
		
		LOGGER.trace("Agate()");
	}
	
	public Agate(int id, double value, double weight) {
		super(id, "Агат", StoneColor.GRAY, 6, Glance.WAX, StoneTransparency.TRANSTLUCENT, 
				CrystalSystem.TRIGONAL,
				1.202, SemiPreciousStoneCategory.SECOND_CATEGORY, weight);
		LOGGER.trace("Agate()");
		setValue(value);
	}

	@Override
	public String promote(Client client) {
		String res = "";
		
		res = "В якості талісмана агат допомагає власникові відкрити обман, виявити недоброзичливців, "
				+ "попереджає про насуваються неприємності.";
		
		if(client.getAge() > 50) 
			res += "Літотерапевти стверджують, що агат здатний допомогти своєму власникові впоратися з багатьма недугами";
		
		return res;
	}
}
