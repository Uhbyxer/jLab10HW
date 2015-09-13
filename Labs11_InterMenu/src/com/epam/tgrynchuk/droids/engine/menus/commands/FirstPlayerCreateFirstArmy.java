package com.epam.tgrynchuk.droids.engine.menus.commands;

import com.epam.tgrynchuk.droids.engine.BattleController;
import com.epam.tgrynchuk.droids.engine.menus.Command;

/**
 * @author Taras Grynchuk
 * <br><b>��������� ������ ����: ���� 1-�� ������� ��쳿 ��� 1-�� ����������� </b><br>
 *
 * @see com.epam.tgrynchuk.droids.engine.menus.Command
 * @see com.epam.tgrynchuk.droids.engine.menus.Menu
 */
public class FirstPlayerCreateFirstArmy implements Command {
	private BattleController controller;
	
	public FirstPlayerCreateFirstArmy(BattleController controller) {
		this.controller = controller;
	}
	
	@Override
	public void execute() {
		controller.firstPlayerCreateFirstArmy();
	}

	@Override
	public String getKey() {
		return "1";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> " + controller.getMessage("7_Jedis");
	}

}
