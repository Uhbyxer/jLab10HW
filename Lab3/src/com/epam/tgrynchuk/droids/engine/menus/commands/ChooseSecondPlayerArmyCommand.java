package com.epam.tgrynchuk.droids.engine.menus.commands;

import com.epam.tgrynchuk.droids.engine.BattleController;
import com.epam.tgrynchuk.droids.engine.menus.Command;

/**
 * @author Taras Grynchuk
 * <br><b>Реалізація пункту меню: Вибір армії для другого користувача </b><br>
 *
 * @see com.epam.tgrynchuk.droids.engine.menus.Command
 * @see com.epam.tgrynchuk.droids.engine.menus.Menu
 */
public class ChooseSecondPlayerArmyCommand implements Command {
	private BattleController controller;
	
	public ChooseSecondPlayerArmyCommand(BattleController controller) {
		this.controller = controller;
	}
	
	@Override
	public void execute() {
		controller.chooseSecondPlayerArmy();
		
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "2";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> 2-st Player: Choose army...";
	}
}
