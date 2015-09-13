package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;

public class QuitProgtramItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(QuitProgtramItem.class);

	@Override
	public boolean execute() {
		LOGGER.info("QuitProgtramItem.execute()");
		System.exit(0);
		return true;
	}

	@Override
	public String getKey() {
		return "q";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Вихід з програми";
	}
}
