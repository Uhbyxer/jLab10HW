package com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.bookeditor.mvc.engine.BookController;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.MenuItem;

public class ChangeLangItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(ChangeLangItem.class);
	
	private BookController controller;

	public ChangeLangItem(BookController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public boolean execute() {
		LOGGER.debug("ChangeLangItem.execute()");
		
		controller.changeLang();
		
		return false;
	}

	@Override
	public String getKey() {
		return "0";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> " + controller.getLocalMessage("menu.change_lang");	
	}
}
