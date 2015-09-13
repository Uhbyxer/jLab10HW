package com.epam.tgrynchuk.bookeditor.mvc.engine.menus;

import java.util.Collection;
import java.util.LinkedHashMap;



public class Menu {
	//����, �� ����� ������ ����������� ���������� ����� ����
	private LinkedHashMap<String, MenuItem> items;
	
	/**
	 * � ����������� ������ ������� ������� ������ ������
	 * @param items ������ ����(�������)
	 */
	public Menu(MenuItem ... items) {
		this.items = new LinkedHashMap<>();
		//�������� ��� � ���
		for(MenuItem item: items)
			this.items.put(item.getKey(), item);
	}
	
	/**
	 * ���� ������� ����� ����� (��������� ������������ ������)
	 * @param key ���� �������
	 * @return �� ����� �� ��������� �����
	 */
	public boolean select(String key) {
		//�������� � ���� ������� �� ����� �� �������� ��
		//���� �� ������� ������� - �������� ����� �������� �������
		return items.getOrDefault(key, NULL).execute();
	}
	
	//����� �������
	private static final MenuItem NULL = new MenuItem() {
		
		@Override
		public String getKey() {
			return "";
		}
		
		@Override
		public boolean execute() {
			return false;
		}


	};
	
	/**
	 * �������� �������� ������ � ����
	 * @return �������� ������� ������
	 */
	public Collection<? extends Object> getItems() {
		return items.values();
	}
}
