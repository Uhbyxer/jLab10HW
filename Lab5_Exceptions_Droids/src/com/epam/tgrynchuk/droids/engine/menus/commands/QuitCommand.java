package com.epam.tgrynchuk.droids.engine.menus.commands;

import com.epam.tgrynchuk.droids.engine.menus.Command;

/**
 * @author Taras Grynchuk
 * <br><b>Реалізація пункту меню: Вихід з програми </b><br>
 *
 * @see com.epam.tgrynchuk.droids.engine.menus.Command
 * @see com.epam.tgrynchuk.droids.engine.menus.Menu
 */
public class QuitCommand implements Command {

	@Override
	public void execute() {
		System.exit(0);
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "q";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Quit program";
	}

}
