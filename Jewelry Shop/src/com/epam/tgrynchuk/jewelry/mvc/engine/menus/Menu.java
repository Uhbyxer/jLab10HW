package com.epam.tgrynchuk.jewelry.mvc.engine.menus;

import java.util.Collection;
import java.util.LinkedHashMap;



public class Menu {
	//Мапа, де певній клавіші співвідносимо конкретний пункт меню
	private LinkedHashMap<String, MenuItem> items;
	
	/**
	 * в конструкторі додаємо довільну кількість пунктів команд
	 * @param items пункти меню(команди)
	 */
	public Menu(MenuItem ... items) {
		this.items = new LinkedHashMap<>();
		//зберігаємо все в Мапі
		for(MenuItem item: items)
			this.items.put(item.getKey(), item);
	}
	
	/**
	 * вибір команди згідно ключа (натиснутої користувачем клавіші)
	 * @param key ключ команди
	 * @return чи вийти на попередній рівень
	 */
	public boolean select(String key) {
		//отримуємо з мапи команду по ключу та виконуємо її
		//якщо не знайшли команди - виконуємо пусту фіктивну команду
		return items.getOrDefault(key, NULL).execute();
	}
	
	//Пуста команда
	private static final MenuItem NULL = new MenuItem() {
		
		@Override
		public String getKey() {
			return "";
		}
		
		@Override
		public boolean execute() {
			return false;
		}


	};
	
	/**
	 * Отримаємо колекцію команд з мапи
	 * @return отримана колеція команд
	 */
	public Collection<? extends Object> getItems() {
		return items.values();
	}
}
