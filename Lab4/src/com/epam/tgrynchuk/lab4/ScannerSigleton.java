package com.epam.tgrynchuk.lab4;

import java.util.Scanner;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>���� ѳ������ ��� ������� �����</b><br>
 * 
 * @see com.epam.tgrynchuk.droids.ui.Window
 */
public class ScannerSigleton {
	private static Scanner scanner;
	
	private ScannerSigleton() {}
	
	/**
	 * �������� ������
	 * @return ������
	 */
	public static Scanner getScanner() {
		if(scanner == null) 
			scanner = new Scanner(System.in);
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
	 * �������� ����� � ���������
	 * @return �����
	 */
	public static int readInt() {
		int res = 0;
		for(;;) {
			if(getScanner().hasNextInt()) {
				res = getScanner().nextInt();
				break;
			}
			readString();
			System.err.println("It is not integer value !!! Try again...");
		}
		return res;
	}	
	
}
