package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.exceptions.BaseJewelryException;
import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.Menu;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.jewelry.mvc.models.Client;

public class BuyItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(BuyItem.class);
	private final JewelryController controller;
	
	public BuyItem(JewelryController controller) {
		this.controller = controller;
		LOGGER.trace("BuyItem(JewelryController controller)");

	}

	@Override
	public boolean execute() {
		LOGGER.debug("BuyItem.execute()");
		//створюємо меню
		Menu menu = new Menu(
				new BackItem(),
				new NewBuyItem(controller),
				new ShowBuyItem(controller),
				new SortBucketByNamesItem(controller),
				new SortBucketByValueAsc(controller),
				new SortBucketByValueDesc(controller),
				new FindStonesInTransparencyRange(controller)
	    );
	
		for(;;) {
			//key - клавіша, яку ввів користувач 
			String key = controller.getWindow().showMenu(menu.getItems());
			//виконнання команди, згідно натиснутої клавіші
			LOGGER.info("select " + key);
			if(menu.select(key)) break;
		} 
		return true;
		
	}

	@Override
	public String getKey() {
		return "3";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Купівля >";
	}
}
