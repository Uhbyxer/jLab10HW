package com.epam.tgrynchuk.droids.engine.menus.commands;

import com.epam.tgrynchuk.droids.engine.BattleController;
import com.epam.tgrynchuk.droids.engine.menus.Command;

/**
 * @author Taras Grynchuk
 * <br><b>��������� ������ ����: ���� 2-�� ������� ��쳿 ��� 2-�� ����������� </b><br>
 *
 * @see com.epam.tgrynchuk.droids.engine.menus.Command
 * @see com.epam.tgrynchuk.droids.engine.menus.Menu
 */
public class SecondPlayerCreateSecondArmy implements Command {
	private BattleController controller;
	
	public SecondPlayerCreateSecondArmy(BattleController controller) {
		this.controller = controller;
	}
	
	@Override
	public void execute() {
		controller.secondPlayerCreateSecondArmy();
	}

	@Override
	public String getKey() {
		return "2";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> " + controller.getMessage("5_Siths");
	}
}
