package com.epam.tgrynchuk.droids.engine.menus.commands;

import com.epam.tgrynchuk.droids.engine.BattleController;
import com.epam.tgrynchuk.droids.engine.menus.Command;

/**
 * @author Taras Grynchuk
 * <br><b>��������� ������ ����: ���� 1-�� ������� ��쳿 ��� 2-�� ����������� </b><br>
 *
 * @see com.epam.tgrynchuk.droids.engine.menus.Command
 * @see com.epam.tgrynchuk.droids.engine.menus.Menu
 */
public class SecondPlayerCreateFirstArmy implements Command {
	private BattleController controller;
	
	public SecondPlayerCreateFirstArmy(BattleController controller) {
		this.controller = controller;
	}
	
	@Override
	public void execute() {
		controller.secondPlayerCreateFirstArmy();
	}

	@Override
	public String getKey() {
		return "1";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> " + controller.getMessage("7_Siths");
	}
}
