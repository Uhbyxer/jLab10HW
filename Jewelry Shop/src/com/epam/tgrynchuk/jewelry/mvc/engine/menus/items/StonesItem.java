package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;


import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.Menu;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;

public class StonesItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(StonesItem.class);
			
	private final JewelryController controller;
	
	public StonesItem(JewelryController controller) {
		this.controller = controller;
		
		LOGGER.trace("StonesItem()");
	}

	@Override
	public boolean execute() {
		LOGGER.debug("StonesItem.execute()");
		
		//створюємо меню
		Menu menu = new Menu(
				new BackItem(),
				new StonesListShowItem(controller),
				new StonesAddNewItem(controller),
				new StonesDeleteItem(controller)
	    );
	
		for(;;) {
			//key - клавіша, яку ввів користувач 
			String key = controller.getWindow().showMenu(menu.getItems());
			//виконнання команди, згідно натиснутої клавіші
			
			LOGGER.debug("menu.select " + key);
			if(menu.select(key)) break;
		} 
		return true;
	}

	@Override
	public String getKey() {
		return "0";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Каменi >";
	}


}

