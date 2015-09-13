package com.epam.tgrynchuk.jewelry.mvc.ui;

import java.util.Collection;
import java.util.Set;

import org.apache.log4j.Logger;



public class Window {
	private static final Logger LOGGER = Logger.getLogger(Window.class);
	
	public void showCollection(Collection<? extends Object> collection) {
		collection.forEach(System.out::println);
		LOGGER.debug(collection);
	}
	
	public void showCollection(Collection<? extends Object> collection, String message) {
		System.out.println(message);
		LOGGER.debug(message);
		showCollection(collection);
	}
	
	public String showMenu(Collection<? extends Object> menu) {
		System.out.println("\n========== Menu ==========");
		showCollection(menu);
		System.out.println("==========================");
		System.out.print("Enter your choise: ");
		LOGGER.debug(menu);
		return ScannerSigleton.readString();
	}
	
	public int enterInt(String message) {
		System.out.println(message);
		LOGGER.debug(message);
		return ScannerSigleton.readPositiveInt();
	}
	
	public int enterInt(String message, int from, int to) {
		System.out.println(message);
		LOGGER.debug(message);
		return ScannerSigleton.readPositiveInt(from, to);
	}
	
	public int enterInt(String message, Set<Integer> set) {
		System.out.println(message);
		LOGGER.debug(message);
		return ScannerSigleton.readPositiveInt(set);
	}
	
	public double enterDouble(String message) {
		System.out.println(message);
		LOGGER.debug(message);
		return ScannerSigleton.readPositiveDouble();
	}
	
	public String enterString(String message) {
		System.out.println(message);
		LOGGER.debug(message);
		return ScannerSigleton.readString();
	}
	
	/**
	 * Вивести повідомлення про помилку
	 * @param message текст повідомлення
	 */
	public void showError(String message) {
		System.err.println(message);
		LOGGER.warn(message);
	}
	
	/**
	 * Вивести повідомлення
	 * @param message текст повідомлення
	 */
	public void showMessage(String message) {
		System.out.println(message);
		LOGGER.debug(message);
	}
}
