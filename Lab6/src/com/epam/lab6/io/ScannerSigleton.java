package com.epam.lab6.io;

import java.util.Scanner;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>Клас Сінглтон для сканера вводу</b><br>
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
		return getScanner().next();
	}
	
	/**
	 * Отримати число з клавіатури
	 * @return число
	 */
	public static int readPositiveInt() {
		int res = 0;
		for(;;) {
			if(getScanner().hasNextInt()) {
				res = getScanner().nextInt();
				if(res > 0)
					break;
				System.err.println("Integer is negative or zero. Try again...");
			}
			readString();
			System.err.println("It is not integer value !!! Try again...");
		}
		return res;
	}	
	
}
