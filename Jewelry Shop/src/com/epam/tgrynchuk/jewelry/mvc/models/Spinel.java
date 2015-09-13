package com.epam.tgrynchuk.jewelry.mvc.models;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.models.enums.*;


public class Spinel extends PreciousStone {
	private static final Logger LOGGER = Logger.getLogger(Spinel.class);

	public Spinel(int id, String name, StoneColor color, int firmness, Glance glance,
			StoneTransparency transparency, CrystalSystem crystalSystem,
			double refractionIndex, PreciousStoneCategory category,
			double weight) {
		super(id, name, color, firmness, glance, transparency, crystalSystem,
				refractionIndex, category, weight);
		
		LOGGER.trace(getClass().getSimpleName());
	}
	
	public Spinel(int id, double value, double weight) {
		super(id, "Шпiнель", StoneColor.COLORLESS, 7, Glance.GLASS, StoneTransparency.TRANSTLUCENT, 
				CrystalSystem.CUBIC,
				1.775, PreciousStoneCategory.SECOND_CATEGORY, weight);
		setValue(value);
		
		LOGGER.trace(getClass().getSimpleName());
	}

	@Override
	public String promote(Client client) {
		String res = "";
		
		res = "У давнину шпінель вважали каменем лікарів і вчених, символом здійснення бажань.";
		
		return res;
	}

}
