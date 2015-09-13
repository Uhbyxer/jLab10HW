package com.epam.droidmenu;

/**
 * @author Taras Grynchuk
 * <br><b>Інтерфейс Команда</b><br>
 * Реалізація меню через клас: Menu, реалізації конкретних команд в 
 * класах пакету com.epam.tgrynchuk.droids.engine.menus.commands
 * 
 * @see com.epam.tgrynchuk.droids.engine.menus.Menu
 * @see com.epam.tgrynchuk.droids.engine.menus.commands.StartTheBattleCommand
 * @see com.epam.tgrynchuk.droids.engine.menus.commands.FirstPlayerCreateFirstArmy
 * @see com.epam.tgrynchuk.droids.engine.menus.commands.FirstPlayerCreateSecondArmy
 * @see com.epam.tgrynchuk.droids.engine.menus.commands.FirstPlayerCreateThirdArmy
 * @see com.epam.tgrynchuk.droids.engine.menus.commands.GoBackCommand
 * @see com.epam.tgrynchuk.droids.engine.menus.commands.ChooseFirstPlayerArmyCommand
 * @see com.epam.tgrynchuk.droids.engine.menus.commands.QuitCommand
 * @see com.epam.tgrynchuk.droids.engine.menus.commands.SecondPlayerCreateFirstArmy
 * @see com.epam.tgrynchuk.droids.engine.menus.commands.SecondPlayerCreateSecondArmy
 * @see com.epam.tgrynchuk.droids.engine.menus.commands.SecondPlayerCreateThirdArmy
  * 
 */
public interface Command {
	/**
	 * виконати команду
	 */
	void execute();
	
	
	/**
	 * ключ (клавіша для вибору команди)
	 * @return строковий ключ команди
	 */
	String getKey();
}
