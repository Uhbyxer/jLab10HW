package com.epam.lab8.cmd;

import java.util.Scanner;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>Клас Сінглтон для сканера вводу</b><br>
 * 
 * @see com.epam.tgrynchuk.droids.ui.Window
 */
public class ScannerSigleton {
	private static Scanner scanner;
	
	private ScannerSigleton() {}
	
	/**
	 * Отримати сканер
	 * @return сканер
	 */
	public static Scanner getScanner() {
		if(scanner == null) 
			scanner = new Scanner(System.in);
		return scanner;
	}
	
	/**
	 * Отримати строку з клавіатури
	 * @return введена строка
	 */
	public static String readString() {
		return getScanner().nextLine();
	}
}
