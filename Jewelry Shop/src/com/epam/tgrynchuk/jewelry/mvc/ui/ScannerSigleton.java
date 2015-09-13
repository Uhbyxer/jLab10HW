package com.epam.tgrynchuk.jewelry.mvc.ui;

import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.models.Turquoise;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>���� ѳ������ ��� ������� �����</b><br>
 * 
 * @see com.epam.tgrynchuk.jewelry.mvc.ui.Window
 */
public class ScannerSigleton {
	private static final Logger LOGGER = Logger.getLogger(ScannerSigleton.class);
	private static Scanner scanner;
	
	private ScannerSigleton() {}
	
	/**
	 * �������� ������
	 * @return ������
	 */
	public static Scanner getScanner() {
		if(scanner == null) {
			scanner = new Scanner(System.in);
			
			LOGGER.trace("ScannerSigleton()");
		}
		return scanner;
	}
	
	/**
	 * �������� ������ � ���������
	 * @return ������� ������
	 */
	public static String readString() {
		return getScanner().next();
	}
	
	/**
	 * �������� ���� ����� � ���������
	 * @return �����
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
	 * �������� ������� ����� � ���������
	 * @return �����
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
