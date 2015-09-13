package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import static com.epam.tgrynchuk.jewelry.utils.ClassInfo.getStoneClassCount;
import static com.epam.tgrynchuk.jewelry.utils.ClassInfo.getStoneClassNameByIndex;
import static com.epam.tgrynchuk.jewelry.utils.ClassInfo.getStoneClassNamesWithIndexes;
import static com.epam.tgrynchuk.jewelry.utils.Reflection.*;
import static com.epam.tgrynchuk.jewelry.utils.TextFile.*;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.exceptions.BadConsoleCommandException;
import com.epam.tgrynchuk.jewelry.exceptions.BaseJewelryException;
import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.ConsoleCommand;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.jewelry.mvc.models.Client;
import com.epam.tgrynchuk.jewelry.mvc.models.Stone;

public class ClientsAddNewItem implements MenuItem, ConsoleCommand {
	private static final Logger LOGGER = Logger.getLogger(ClientsAddNewItem.class);
	
	private final JewelryController controller;
	
	public ClientsAddNewItem(JewelryController controller) {
		LOGGER.trace("ClientsAddNewItem()");
		
		this.controller = controller;
	}

	@Override
	public boolean execute() {
		LOGGER.debug("ClientsAddNewItem.execute()");
		
		String name = controller.getWindow().enterString("Ім'я : ");
	    int age = controller.getWindow().enterInt("Вік, 16+ : ", 16, Integer.MAX_VALUE);
	    int sex = controller.getWindow().enterInt("Стать, 1 - чоловік, 0 - жінка: ", 0, 1); 	
	    
	    return execute(name, age, sex);
		
	}
	
	public boolean execute(String name, int age, int sex) {
	    LOGGER.debug("try instance = newInstanceOfClient");
	    try {
	    	Client instance = newInstanceOfClient(name, age, sex == 1);  
	    	LOGGER.info("newInstanceOfClient " + instance);
			
	    	controller.getListOfClients().add(instance);
	    	LOGGER.info("getListOfClients().add " + instance);
	    	
			saveListOfClientsToFile(this.controller.getListOfClients());
			LOGGER.info("saveListOfClientsToFile");
			
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
		return getKey() + " --> Додати нового клієнта...";
	}

	@Override
	public boolean executeFromConsole(String[] args) {
		try {
			execute(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		} catch(BaseJewelryException e) {
			throw new BadConsoleCommandException(e);
		}
		return false;
	}

	@Override
	public String getConsoleKey() {
		return "addclient";
	}

	@Override
	public String getSignature() {
		return getConsoleKey() + ";name;age;sex; - Додати нового клієнта" ;
	}


}
