package com.epam.tgrynchuk.bookeditor.mvc.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;



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
					System.err.println(getLocalMessage("Integer_is_out_of_bounds"));
					LOGGER.warn(getLocalMessage("Integer_is_out_of_bounds"));
				}
			} else {
				readString();
				System.err.println(getLocalMessage("It_is_not_integer"));
				LOGGER.warn(getLocalMessage("It_is_not_integer"));
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
					System.err.println(getLocalMessage("Integer_is_out_of_bounds"));
					LOGGER.warn(getLocalMessage("Integer_is_out_of_bounds"));
				}
			} else {
				readString();
				System.err.println(getLocalMessage("It_is_not_integer"));
				LOGGER.warn(getLocalMessage("It_is_not_integer"));
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
					System.err.println(getLocalMessage("Float_number_is_negative"));
					LOGGER.warn(getLocalMessage("Float_number_is_negative"));
				}
			} else {
				readString();
				System.err.println(getLocalMessage("It_is_not_float"));
				LOGGER.warn(getLocalMessage("It_is_not_float"));
			}	
		}
		return res;
	}
	
	
	private static ResourceBundle resBundle = null;
	
	public static void setResourceBundle(ResourceBundle newBundle) {
		resBundle = newBundle;
	}
	
	private static Map<String, String> messages;
	
	
	static {
		messages = new HashMap<>();
		messages.put("Integer_is_out_of_bounds", "Integer is out of bounds. Try again...");
		messages.put("It_is_not_integer", "It is not integer value !!! Try again...");
		
		messages.put("Float_number_is_negative", "Float number is negative. Try again...");
		messages.put("It_is_not_float", "It is not float value !!! Try again...");
	}
	
	private static String getLocalMessage(String key) {
		if(resBundle != null) {
			try {
				return resBundle.getString(key);
			} catch(Exception e) {
				
			}
		}	
		return messages.getOrDefault(key, null);
	}
	
	
	
}
