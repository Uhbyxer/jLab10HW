package com.epam.tgrynchuk.jewelry.mvc.models;


import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.models.enums.*;

public class Diamond extends PreciousStone {
	private static final Logger LOGGER = Logger.getLogger(Diamond.class);

	public Diamond(int id, String name, StoneColor color, int firmness, Glance glance,
			StoneTransparency transparency, CrystalSystem crystalSystem,
			double refractionIndex, PreciousStoneCategory category,
			double weight) {
		super(id, name, color, firmness, glance, transparency, crystalSystem,
				refractionIndex, category, weight);
		
		LOGGER.trace("Diamond()");
	}
	
	public Diamond(int id, double value, double weight) {
		super(id, "Алмаз", StoneColor.COLORLESS, 8, Glance.DIAMOND, StoneTransparency.CLEAR, 
				CrystalSystem.CUBIC,
				2.402, PreciousStoneCategory.FIRST_CATEGORY, weight);
		setValue(value);
		LOGGER.trace("Diamond()");
	}

	@Override
	public String promote(Client client) {
		String res = "";
		
		res = "Алмаз - це, мабуть, найпопулярніший, самий коштовний камінь в світі.";
		
		if(client.isMale()) 
			res += "Алмаз збільшить твердість в прийнятті рішень і мужність його власника.";
		
		return res;
	}
}
