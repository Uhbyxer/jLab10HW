package com.epam.tgrynchuk.jewelry.mvc.models;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.models.enums.*;


public class Turquoise extends SemiPreciousStone {
	private static final Logger LOGGER = Logger.getLogger(Turquoise.class);

	public Turquoise(int id, String name, StoneColor color, int firmness,
			Glance glance, StoneTransparency transparency,
			CrystalSystem crystalSystem, double refractionIndex,
			SemiPreciousStoneCategory category, double weight) {
		super(id, name, color, firmness, glance, transparency, crystalSystem,
				refractionIndex, category, weight);
		
		LOGGER.trace(getClass().getSimpleName());
	}
	
	public Turquoise(int id, double value, double weight) {
		super(id, "Бiрюза", StoneColor.GREEN, 5, Glance.WAX, StoneTransparency.OPAQUE, 
				CrystalSystem.TRICLINIC,
				0, SemiPreciousStoneCategory.FIRST_CATEGORY, weight);
		setValue(value);
		
		LOGGER.trace(getClass().getSimpleName());
	}

	@Override
	public String promote(Client client) {
		String res = "";
		
		res = "Бірюзу завжди вважали каменем щастя.";
		
		if(client.isMale()) 
			res += "Це камінь борців, лідерів, хоробрих, рішучих і незалежних чоловіків.";
		else
			res += "Цей камінь дозволить укріпити сімейні стосунки.";
		
		return res;
	}
}
