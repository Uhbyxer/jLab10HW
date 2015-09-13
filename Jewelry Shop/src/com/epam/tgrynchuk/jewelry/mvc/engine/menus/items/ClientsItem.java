package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.Menu;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;

public class ClientsItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(ClientsItem.class);
	
	private final JewelryController controller;
	
	public ClientsItem(JewelryController controller) {
		this.controller = controller;
		
		LOGGER.trace("ClientsItem()");
	}

	@Override
	public boolean execute() {
		LOGGER.debug("ClientsItem.execute() ");
		//створюємо меню
		Menu menu = new Menu(
				new BackItem(),
				new ClientsItemsListShowItem(controller),
				new ClientsAddNewItem(controller),
				new ClientsDeleteItem(controller)
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
		return "1";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Клієнти >";
	}
}
