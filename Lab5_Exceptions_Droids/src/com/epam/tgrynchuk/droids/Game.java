package com.epam.tgrynchuk.droids;

import com.epam.tgrynchuk.droids.engine.BattleController;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>Точка входу в програму</b><br>
 * 
 * Структура програми:<br><ul>
 * <li><i>com.epam.tgrynchuk.droids.engine</i> - контроллер програми, (класи: BattleController, Menu, інтерфейс: 
 * Command)</li>
 * 
 * <li><i>com.epam.tgrynchuk.droids.model</i> - модель програми, (класи: Droid, Blaster,
 * BattleDroid, BattleRepairDroid, Army, інтерфейси: Valuable, Repairer)</li>
 * 
 * <li><i>com.epam.tgrynchuk.droids.ui</i> - користувацький інтерфейс програми, (класи: Window, ScannerSigleton)</li>
 * </ul>
 * 
 * @see com.epam.tgrynchuk.droids.model.Droid
 * @see com.epam.tgrynchuk.droids.model.Blaster
 * @see com.epam.tgrynchuk.droids.model.BattleDroid
 * @see com.epam.tgrynchuk.droids.model.BattleRepairDroid
 * @see com.epam.tgrynchuk.droids.model.Army
 * @see com.epam.tgrynchuk.droids.model.Valuable
 * @see com.epam.tgrynchuk.droids.model.Repairer
 * @see com.epam.tgrynchuk.droids.engine.menus.Menu
 * @see com.epam.tgrynchuk.droids.engine.menus.Command
 * @see com.epam.tgrynchuk.droids.ui.ScannerSigleton
 * @see com.epam.tgrynchuk.droids.ui.Window
 * 
 */
public class Game {
	
	public static void main(String[] args) {
		//створення та запуск контроллера програми
		BattleController controller = new BattleController();
		controller.run();
			
	}

}
