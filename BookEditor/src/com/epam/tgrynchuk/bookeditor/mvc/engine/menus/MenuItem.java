package com.epam.tgrynchuk.bookeditor.mvc.engine.menus;

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
