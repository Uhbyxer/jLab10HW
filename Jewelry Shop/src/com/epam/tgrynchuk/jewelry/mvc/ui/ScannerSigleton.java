package com.epam.tgrynchuk.jewelry.mvc.ui;

import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.models.Turquoise;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>Клас Сінглтон для сканера вводу</b><br>
 * 
 * @see com.epam.tgrynchuk.jewelry.mvc.ui.Window
 */
public class ScannerSigleton {
	private static final Logger LOGGER = Logger.getLogger(ScannerSigleton.class);
	private static Scanner scanner;
	
	private ScannerSigleton() {}
	
	/**
	 * Отримати сканер
	 * @return сканер
	 */
	public static Scanner getScanner() {
		if(scanner == null) {
			scanner = new Scanner(System.in);
			
			LOGGER.trace("ScannerSigleton()");
		}
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
	 * Отримати ціле число з клавіатури
	 * @return число
	 */
	public static int readPositiveInt() {
		return readPositiveInt(0, Integer.MAX_VALUE);
	}	
	
	public static int readPositiveInt(int from, int to) {
		int res = 0;
		for(;;) {
			if(getScanner().hasNextInt()) {
				res = getScanner().nextInt();
				if(res >= from && res <= to)
					break;
				else {
					System.err.println("Integer is out of bounds. Try again...");
					LOGGER.warn("Integer is out of bounds. Try again...");
				}
			} else {
				readString();
				System.err.println("It is not integer value !!! Try again...");
				LOGGER.warn("It is not integer value !!! Try again...");
			}	
		}
		return res;
	}	
	
	public static int readPositiveInt(Set<Integer> set) {
		int res = 0;
		for(;;) {
			if(getScanner().hasNextInt()) {
				res = getScanner().nextInt();
				if(set.contains(res))
					break;
				else {
					System.err.println("Integer is out of bounds. Try again...");
					LOGGER.warn("Integer is out of bounds. Try again...");
				}
			} else {
				readString();
				System.err.println("It is not integer value !!! Try again...");
				LOGGER.warn("It is not integer value !!! Try again...");
			}	
		}
		return res;
	}		
	/**
	 * Отримати дробове число з клавіатури
	 * @return число
	 */
	public static double readPositiveDouble() {
		double res = 0;
		for(;;) {
			if(getScanner().hasNextDouble()) {
				res = getScanner().nextDouble();
				if(res >= 0)
					break;
				else {
					System.err.println("Float number is negative. Try again...");
					LOGGER.warn("Float number is negative. Try again...");
				}
			} else {
				readString();
				System.err.println("It is not float value !!! Try again...");
				LOGGER.warn("It is not float value !!! Try again...");
			}	
		}
		return res;
	}
	
}
