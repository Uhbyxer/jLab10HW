package com.epam.tgrynchuk.jewelry.mvc.models;


import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.models.enums.*;

public class Ruby extends PreciousStone {
	private static final Logger LOGGER = Logger.getLogger(Ruby.class);

	public Ruby(int id, String name, StoneColor color, int firmness, Glance glance,
			StoneTransparency transparency, CrystalSystem crystalSystem,
			double refractionIndex, PreciousStoneCategory category,
			double weight) {
		super(id, name, color, firmness, glance, transparency, crystalSystem,
				refractionIndex, category, weight);
		
		LOGGER.trace("Ruby()");
	}

	public Ruby(int id, double value, double weight) {
		super(id, "Рубiн", StoneColor.RED, 9, Glance.GLASS, StoneTransparency.SEMITRANSPARENT, 
				CrystalSystem.TRIGONAL,
				1.762, PreciousStoneCategory.FIRST_CATEGORY, weight);
		setValue(value);
		
		LOGGER.trace("Ruby()");
	}

	@Override
	public String promote(Client client) {
		String res = "";
		
		res = "Рубін - камінь особливої магічної сили, камінь випробувань, володіння силами енергії.";
		
		if(client.getAge() > 50) 
			res += "Як лікувальний камінь рубін рекомендують носити людям, які страждають підвищеним артеріальним тиском.";
		
		return res;
	}
	

}
