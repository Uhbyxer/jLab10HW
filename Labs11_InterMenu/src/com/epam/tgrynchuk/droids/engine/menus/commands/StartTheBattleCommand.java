package com.epam.tgrynchuk.droids.engine.menus.commands;

import com.epam.tgrynchuk.droids.engine.BattleController;
import com.epam.tgrynchuk.droids.engine.menus.Command;


/**
 * @author Taras Grynchuk
 * <br><b>Реалізація пункту меню: Почати битву </b><br>
 *
 * @see com.epam.tgrynchuk.droids.engine.menus.Command
 * @see com.epam.tgrynchuk.droids.engine.menus.Menu
 */
public class StartTheBattleCommand implements Command {
	
	private BattleController controller;

	public StartTheBattleCommand(BattleController controller) {
		this.controller = controller;
	}
	
	@Override
	public void execute() {
		controller.startTheBattle();
	}

	@Override
	public String getKey() {
		return "0";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> " + controller.getMessage("Start_the_battle");
	}

}
