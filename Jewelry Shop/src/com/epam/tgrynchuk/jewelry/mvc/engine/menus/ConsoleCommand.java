package com.epam.tgrynchuk.jewelry.mvc.engine.menus;

public interface ConsoleCommand {
	/**
	 * �������� ������� � ������
	 * @param args ��������� �������
	 * @return �� ����� � �������� ����
	 */
	boolean executeFromConsole(String[] args);
	
	
	/**
	 * ���� (������ ��� ������ �������)
	 * @return ��������� ���� �������
	 */
	String getConsoleKey();
	
	/**
	 * ��������� �������
	 * @return ���������
	 */
	String getSignature();
}
