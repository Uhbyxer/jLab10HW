package com.epam.tgrynchuk.jewelry.mvc.engine.menus;

import java.util.Collection;
import java.util.LinkedHashMap;

import com.epam.tgrynchuk.jewelry.exceptions.BadConsoleCommandException;
import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;

public class Console {
	//Мапа, де певній строці співвідносимо конкретну команду
	private LinkedHashMap<String, ConsoleCommand> items;
	
	/**
	 * в конструкторі додаємо довільну кількість пунктів команд
	 * @param items пункти меню(команди)
	 */
	public Console(ConsoleCommand ... items) {
		this.items = new LinkedHashMap<>();
		//зберігаємо все в Мапі
		for(ConsoleCommand item: items)
			this.items.put(item.getConsoleKey(), item);
	}
	
	/**
	 * вибір команди згідно ключа (натиснутої користувачем клавіші)
	 * @param key ключ команди
	 * @return чи вийти на попередній рівень
	 */
	public boolean select(String key) {
		//отримуємо з мапи команду по ключу та виконуємо її
		//якщо не знайшли команди - виконуємо пусту фіктивну команду
		
		String[] args = key.split(";");
		
		return items.getOrDefault(args[0], NULL).executeFromConsole(args);
	}
	
	//Пуста команда
	private static final ConsoleCommand NULL = new ConsoleCommand() {

		@Override
		public boolean executeFromConsole(String[] args) {
			throw new BadConsoleCommandException("Bad command ! Try again...");
		}

		@Override
		public String getConsoleKey() {
			return "";
		}

		@Override
		public String getSignature() {
			return "";
		}

	};
	
	public Collection<ConsoleCommand> getItems() {
		return items.values();
	}
	
	
}
