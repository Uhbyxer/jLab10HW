package com.epam.tgrynchuk.droids.engine.menus;

import java.util.Collection;

import java.util.LinkedHashMap;

/**
 * @author Taras Grynchuk
 * <br><b>Клас Меню</b><br>
 *
 * @see com.epam.tgrynchuk.droids.engine.menus.Command
 */
public class Menu {
	//Мапа, де певній клавіші співвідносимо конкретний пункт меню
	private LinkedHashMap<String, Command> commands;
	
	/**
	 * в конструкторі додаємо довільну кількість пунктів команд
	 * @param commands пункти меню(команди)
	 */
	public Menu(Command ... commands) {
		this.commands = new LinkedHashMap<>();
		//зберігаємо все в Мапі
		for(Command com: commands)
			this.commands.put(com.getKey(), com);
	}
	
	/**
	 * вибір команди згідно ключа (натиснутої користувачем клавіші)
	 * @param key ключ команди
	 */
	public void select(String key) {
		//отримуємо з мапи команду по ключу та виконуємо її
		//якщо не знайшли команди - виконуємо пусту фіктивну команду
		commands.getOrDefault(key, NULL).execute();
	}
	
	//Пуста команда
	private static final Command NULL = new Command() {
		
		@Override
		public String getKey() {
			return "";
		}
		
		@Override
		public void execute() {
		}


	};
	
	/**
	 * Отримаємо колекцію команд з мапи
	 * @return отримана колеція команд
	 */
	public Collection<? extends Object> getCommands() {
		return commands.values();
	}
}
