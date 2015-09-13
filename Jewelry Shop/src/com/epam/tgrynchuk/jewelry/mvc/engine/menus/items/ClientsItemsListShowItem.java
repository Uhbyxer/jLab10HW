package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;

public class ClientsItemsListShowItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(ClientsItemsListShowItem.class);
			
	private final JewelryController controller;
	
	public ClientsItemsListShowItem(JewelryController controller) {
		this.controller = controller;
		
		LOGGER.trace("ClientsItemsListShowItem()");
	}

	@Override
	public boolean execute() {
		LOGGER.debug("ClientsItemsListShowItem.execute() ");
		
		if(controller.getListOfClients().isEmpty())
			controller.getWindow().showError("\n������ �볺��� ������ !");
		else
			controller.getWindow().showCollection(controller.getListOfClients(), "\n������ �볺���:");
	
		return false;
	}

	@Override
	public String getKey() {
		return "1";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> �������� ������ �볺���";
	}
}
