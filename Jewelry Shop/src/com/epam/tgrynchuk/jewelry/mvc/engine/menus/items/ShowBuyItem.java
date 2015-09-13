package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import static com.epam.tgrynchuk.jewelry.utils.TextFile.saveListOfClientsToFile;
import static com.epam.tgrynchuk.jewelry.utils.TextFile.saveListOfStonesToFile;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.exceptions.BaseJewelryException;
import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.jewelry.mvc.models.Client;
import com.epam.tgrynchuk.jewelry.mvc.models.Stone;

public class ShowBuyItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(ShowBuyItem.class);
	
	private final JewelryController controller;
	
	public ShowBuyItem(JewelryController controller) {
		this.controller = controller;
		
		LOGGER.trace("ShowBuyItem()");
	}

	@Override
	public boolean execute() {
		LOGGER.debug("ShowBuyItem.execute()");
		
		if(controller.getBucketOfStones().isEmpty()) {
			controller.getWindow().showError("\nКошик пустий !");
			return false;
		}
		controller.getWindow().showCollection(controller.getBucketOfStones(), "\nКошик:");
	    
	    return false;		
	}

	@Override
	public String getKey() {
		return "2";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Показати кошик";
	}
}
