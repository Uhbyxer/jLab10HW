package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.epam.tgrynchuk.jewelry.exceptions.BaseJewelryException;
import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.jewelry.mvc.models.Client;
import com.epam.tgrynchuk.jewelry.mvc.models.Stone;

public class SortBucketByNamesItem implements MenuItem {
	private final JewelryController controller;
	
	public SortBucketByNamesItem(JewelryController controller) {
		this.controller = controller;
	}

	@Override
	public boolean execute() {
		if(controller.getBucketOfStones().isEmpty()) {
			controller.getWindow().showError("\nКошик пустий !");
			return false;
		}
		Collections.sort(controller.getBucketOfStones());
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
		return "3";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Сортувати кошик за назвами";
	}
}
