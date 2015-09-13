package com.epam.tgrynchuk.droids.engine.menus.commands;

import com.epam.tgrynchuk.droids.engine.menus.Command;

/**
 * @author Taras Grynchuk
 * <br><b>Реалізація пункту меню: Повернутись на вищий рівень </b><br>
 *
 * @see com.epam.tgrynchuk.droids.engine.menus.Command
 * @see com.epam.tgrynchuk.droids.engine.menus.Menu
 */
public class GoBackCommand implements Command {

	@Override
	public void execute() {
	}

	@Override
	public String getKey() {
		return "0";
	}
	@Override
	public String toString() {
		return getKey() + " --> ...";
	}
}
