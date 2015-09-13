package com.epam.tgrynchuk.droids.engine.menus.commands;

import com.epam.tgrynchuk.droids.engine.BattleController;
import com.epam.tgrynchuk.droids.engine.menus.Command;

/**
 * @author Taras Grynchuk
 * <br><b>Реалізація пункту меню: Вибір 2-го варіанту армії для 1-го користувача </b><br>
 *
 * @see com.epam.tgrynchuk.droids.engine.menus.Command
 * @see com.epam.tgrynchuk.droids.engine.menus.Menu
 */
public class FirstPlayerCreateSecondArmy implements Command {
	private BattleController controller;
	
	public FirstPlayerCreateSecondArmy(BattleController controller) {
		this.controller = controller;
	}
	
	@Override
	public void execute() {
		controller.firstPlayerCreateSecondArmy();
	}

	@Override
	public String getKey() {
		return "2";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> " + controller.getMessage("5_Jedis");
	}
}
