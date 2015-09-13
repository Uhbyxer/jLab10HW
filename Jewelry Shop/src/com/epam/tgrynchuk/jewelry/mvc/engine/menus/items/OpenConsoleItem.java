package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.exceptions.BaseJewelryException;
import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.Console;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.ConsoleCommand;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.jewelry.mvc.models.Client;
import com.epam.tgrynchuk.jewelry.mvc.ui.ScannerSigleton;

public class OpenConsoleItem implements MenuItem{
	private static final Logger LOGGER = Logger.getLogger(OpenConsoleItem.class);
	
	private final JewelryController controller;
	
	public OpenConsoleItem(JewelryController controller) {
		LOGGER.trace("OpenConsoleItem()");
		
		this.controller = controller;
	}

	@Override
	public boolean execute() {
		LOGGER.debug("OpenConsoleItem.execute()");

		Console con = new Console(
				new BackItem(), 
				new ClientsAddNewItem(controller),
				new StonesAddNewItem(controller)
				
				);

		controller.getWindow().showMessage("\nList of commands:");
		for(ConsoleCommand c: con.getItems()) {
			controller.getWindow().showMessage(c.getSignature());
		}

		for (;;) {
			controller.getWindow().showMessage("\nEnter command:");
			String command = ScannerSigleton.readString();

			try {
				if (con.select(command))
					break;
			} catch (BaseJewelryException e) {
				controller.getWindow().showError(e.getMessage());
			} catch (Exception e) {
				controller.getWindow().showError("Invalid command format !");
			}

		}

		return false;
	}

	@Override
	public String getKey() {
		return "9";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Відкрити консоль команд...";
	}
}
