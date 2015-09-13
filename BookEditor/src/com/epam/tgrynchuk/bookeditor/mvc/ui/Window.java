package com.epam.tgrynchuk.bookeditor.mvc.ui;

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
	
	public String showMenu(Collection<? extends Object> menu, String MenuMessage, String EnterMessage) {
		System.out.println("\n" + MenuMessage);
		showCollection(menu);
		System.out.println("==========================");
		System.out.print(EnterMessage + " ");
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
	 * ������� ����������� ��� �������
	 * @param message ����� �����������
	 */
	public void showError(String message) {
		System.err.println(message);
		LOGGER.warn(message);
	}
	
	/**
	 * ������� �����������
	 * @param message ����� �����������
	 */
	public void showMessage(String message) {
		System.out.println(message);
		LOGGER.debug(message);
	}
}
