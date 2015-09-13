package com.epam.tgrynchuk.droids.engine.menus.commands;

import com.epam.tgrynchuk.droids.engine.BattleController;
import com.epam.tgrynchuk.droids.engine.menus.Command;

/**
 * @author Taras Grynchuk
 * <br><b>Реалізація пункту меню: Вибір армії для першого користувача </b><br>
 *
 * @see com.epam.tgrynchuk.droids.engine.menus.Command
 * @see com.epam.tgrynchuk.droids.engine.menus.Menu
 */
public class ChooseFirstPlayerArmyCommand implements Command {
	private BattleController controller;
	
	public ChooseFirstPlayerArmyCommand(BattleController controller) {
		this.controller = controller;
	}

	@Override
	public void execute() {
		controller.chooseFirstPlayerArmy();
		
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "1";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> " + controller.getMessage("FirstChoose");
	}
	
}