package com.epam.tgrynchuk.droids.engine.menus.commands;

import com.epam.tgrynchuk.droids.engine.BattleController;
import com.epam.tgrynchuk.droids.engine.menus.Command;
import com.epam.tgrynchuk.droids.exceptions.*;


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
	public void execute()  {			
		
			//try {
				controller.startTheBattle();
			//} catch (EmptyArmyException e) {
				// TODO Auto-generated catch block
			//	throw e;
			//}
	}		

	@Override
	public String getKey() {
		return "0";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Start the battle";
	}

}
