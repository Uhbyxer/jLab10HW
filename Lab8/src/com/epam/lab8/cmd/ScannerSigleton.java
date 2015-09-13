package com.epam.lab8.cmd;

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
		return getScanner().nextLine();
	}
}
