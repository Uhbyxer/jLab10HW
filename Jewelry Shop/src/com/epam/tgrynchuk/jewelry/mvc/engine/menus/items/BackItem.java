package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.engine.menus.ConsoleCommand;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;

public class BackItem implements MenuItem, ConsoleCommand {
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

	@Override
	public boolean executeFromConsole(String[] args) {
		return true;
	}

	@Override
	public String getConsoleKey() {
		return "exit";
	}

	@Override
	public String getSignature() {
		return getConsoleKey() + " - Вихід з консолі";
	}
}
