package com.epam.lab6.io;

import java.util.Scanner;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>���� ѳ������ ��� ������� �����</b><br>
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
