package com.epam.tgrynchuk.jewelry.mvc.engine.menus;

public interface MenuItem {
	/**
	 * виконати команду
	 * @return чи вийти в попереднє меню
	 */
	boolean execute();
	
	
	/**
	 * ключ (клавіша для вибору команди)
	 * @return строковий ключ команди
	 */
	String getKey();
}
