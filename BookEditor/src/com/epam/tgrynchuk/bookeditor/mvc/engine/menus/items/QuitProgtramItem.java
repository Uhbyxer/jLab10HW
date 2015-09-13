package com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.bookeditor.mvc.engine.BookController;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.MenuItem;



public class QuitProgtramItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(QuitProgtramItem.class);

	private BookController controller;
	
	
	public QuitProgtramItem(BookController controller) {
		super();
		this.controller = controller;
	}

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
		return getKey() + " --> " + controller.getLocalMessage("menu.quit");
	}
}