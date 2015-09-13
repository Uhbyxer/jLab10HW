package com.epam.tgrynchuk.droids.engine.menus.commands;

import com.epam.tgrynchuk.droids.engine.BattleController;
import com.epam.tgrynchuk.droids.engine.menus.Command;

/**
 * @author Taras Grynchuk
 * <br><b>Реалізація пункту меню: Вибір 3-го варіанту армії для 1-го користувача </b><br>
 *
 * @see com.epam.tgrynchuk.droids.engine.menus.Command
 * @see com.epam.tgrynchuk.droids.engine.menus.Menu
 */
public class FirstPlayerCreateThirdArmy implements Command{
	private BattleController controller;
	
	public FirstPlayerCreateThirdArmy(BattleController controller) {
		this.controller = controller;
	}
	
	@Override
	public void execute() {
		controller.firstPlayerCreateThirdArmy();
	}

	@Override
	public String getKey() {
		return "3";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Gang of fourth";
	}
}
