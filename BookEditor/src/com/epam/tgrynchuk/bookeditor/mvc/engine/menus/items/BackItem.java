package com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items;

import org.apache.log4j.Logger;


import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.MenuItem;

public class BackItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(BackItem.class);
	
	@Override
	public boolean execute() {
		LOGGER.debug("BackItem.execute()");
		return true;
	}

	@Override
	public String getKey() {
		return "0";
	}
	@Override
	public String toString() {
		return getKey() + " --> ...";
	}

}
