package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.exceptions.BadConsoleCommandException;
import com.epam.tgrynchuk.jewelry.exceptions.BaseJewelryException;
import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.ConsoleCommand;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.jewelry.mvc.models.Stone;

import static com.epam.tgrynchuk.jewelry.utils.ClassInfo.*;
import static com.epam.tgrynchuk.jewelry.utils.Reflection.*;
import static com.epam.tgrynchuk.jewelry.utils.TextFile.*;

public class StonesAddNewItem implements MenuItem, ConsoleCommand {
	private static final Logger LOGGER = Logger.getLogger(StonesAddNewItem.class);
	
	private final JewelryController controller;
	
	public StonesAddNewItem(JewelryController controller) {
		this.controller = controller;
		
		LOGGER.trace("StonesAddNewItem()");
	}

	@Override
	public boolean execute() {
		LOGGER.debug("StonesAddNewItem.execute()");
		
	    int index = controller.getWindow().enterInt("\nВиберіть вид каменя: " + getStoneClassNamesWithIndexes(), 0, getStoneClassCount() - 1);
	    double value = controller.getWindow().enterDouble("Ціна, $: ");
	    double weight = controller.getWindow().enterDouble("Вага, карат: "); 	
	    
	    return execute(index, value, weight);
		
	}
	
	public boolean execute(int index, double value, double weight) {
	    LOGGER.debug("instance = newInstanceOfStone " + getStoneClassNameByIndex(index));
	    try {
	    	Stone instance = newInstanceOfStone("com.epam.tgrynchuk.jewelry.mvc.models." 
	    			+ getStoneClassNameByIndex(index), this.controller.getListOfStones().getNewId(), 
	    			value, weight);
	    	
			controller.getListOfStones().add(instance);
			LOGGER.info("getListOfStones().add " + instance);
			
			saveListOfStonesToFile(this.controller.getListOfStones());
			LOGGER.info("saveListOfStonesToFile");
			
			controller.getWindow().showMessage("Додано: \n" + instance.toString());
			
	    } catch(BaseJewelryException e) {
	    	controller.getWindow().showError(e + "\n" + e.getCause());
	    }
	    
	    return false;
	}

	@Override
	public String getKey() {
		return "2";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Додати новий камінь...";
	}

	@Override
	public boolean executeFromConsole(String[] args) {
		try {
			execute(Integer.parseInt(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
		} catch(BaseJewelryException e) {
			throw new BadConsoleCommandException(e);
		}
		return false;
	}

	@Override
	public String getConsoleKey() {
		// TODO Auto-generated method stub
		return "addstone";
	}

	@Override
	public String getSignature() {
		return getConsoleKey() + ";index;value;weight - Додати новий камінь" ;
	}
}
