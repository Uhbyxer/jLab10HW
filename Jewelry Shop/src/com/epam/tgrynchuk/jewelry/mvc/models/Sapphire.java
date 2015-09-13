package com.epam.tgrynchuk.jewelry.mvc.models;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.models.enums.*;

public class Sapphire extends PreciousStone {
	private static final Logger LOGGER = Logger.getLogger(Sapphire.class);

	public Sapphire(int id, String name, StoneColor color, int firmness, Glance glance,
			StoneTransparency transparency, CrystalSystem crystalSystem,
			double refractionIndex, PreciousStoneCategory category,
			double weight) {
		super(id, name, color, firmness, glance, transparency, crystalSystem,
				refractionIndex, category, weight);
		
		LOGGER.trace(getClass().getSimpleName());
	}
	
	public Sapphire(int id, double value, double weight) {
		super(id, "Сапфiр", StoneColor.BLUE, 9, Glance.GLASS, StoneTransparency.SEMITRANSPARENT, 
				CrystalSystem.TRIGONAL,
				1.778, PreciousStoneCategory.FIRST_CATEGORY, weight);
		setValue(value);
		
		LOGGER.trace(getClass().getSimpleName());
	}

	@Override
	public String promote(Client client) {
		String res = "";
		
		res = "Сапфір вважають каменем вірності, скромності.";
		
		if(client.isMale()) 
			res += "Чоловіка, який подарував своїй обраниці цей камінь, буде обминати зрада.";
		
		return res;
	}
	
}
