package com.epam.tgrynchuk.jewelry.mvc.engine.menus;

public interface MenuItem {
	/**
	 * �������� �������
	 * @return �� ����� � �������� ����
	 */
	boolean execute();
	
	
	/**
	 * ���� (������ ��� ������ �������)
	 * @return ��������� ���� �������
	 */
	String getKey();
}
