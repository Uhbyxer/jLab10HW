package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;

public class StonesListShowItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(StonesListShowItem.class);
			
	private final JewelryController controller;
	
	public StonesListShowItem(JewelryController controller) {
		this.controller = controller;
		
		LOGGER.trace("StonesListShowItem()");
	}

	@Override
	public boolean execute() {
		LOGGER.debug("StonesListShowItem.execute()");
		
		if(controller.getListOfStones().isEmpty())
			controller.getWindow().showError("\nСписок каменів пустий !");
		else
			controller.getWindow().showCollection(controller.getListOfStones(), "\nСписок каменів:");
	
		return false;
	}

	@Override
	public String getKey() {
		return "1";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Показати список доступних каменів";
	}
}
