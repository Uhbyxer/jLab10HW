package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.exceptions.BaseJewelryException;
import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.jewelry.mvc.models.Client;
import com.epam.tgrynchuk.jewelry.mvc.models.Stone;

public class SortBucketByValueDesc implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(SortBucketByValueDesc.class);
			
	private final JewelryController controller;
	
	public SortBucketByValueDesc(JewelryController controller) {
		this.controller = controller;
		
		LOGGER.trace("SortBucketByValueDesc()");
	}

	@Override
	public boolean execute() {
		LOGGER.debug("SortBucketByValueDesc.execute()");
		
		if(controller.getBucketOfStones().isEmpty()) {
			controller.getWindow().showError("\nКошик пустий !");
			return false;
		}
		controller.getBucketOfStones().sort(Stone.BY_VALUE_DESC_ORDER);
		controller.getWindow().showCollection(controller.getBucketOfStones(), "\nКошик:");
		controller.getWindow().showMessage(
				"Загальна вага: "
						+ controller.getBucketOfStones().getWeight());
		controller.getWindow().showMessage(
				"Загальна вартість: "
						+ controller.getBucketOfStones().getValue());		
		
	    return false;		
	}

	@Override
	public String getKey() {
		return "5";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Сортувати кошик по спаданню вартості";
	}
}
