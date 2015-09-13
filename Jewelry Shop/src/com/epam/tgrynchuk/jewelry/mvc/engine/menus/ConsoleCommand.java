package com.epam.tgrynchuk.jewelry.mvc.engine.menus;

public interface ConsoleCommand {
	/**
	 * виконати команду з консолі
	 * @param args аргументи команди
	 * @return чи вийти в попереднє меню
	 */
	boolean executeFromConsole(String[] args);
	
	
	/**
	 * ключ (клавіша для вибору команди)
	 * @return строковий ключ команди
	 */
	String getConsoleKey();
	
	/**
	 * Сигнатура команди
	 * @return Сигнатура
	 */
	String getSignature();
}
