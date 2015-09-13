package com.epam.tgrynchuk.jewelry.mvc.engine.menus;

import java.util.Collection;
import java.util.LinkedHashMap;

import com.epam.tgrynchuk.jewelry.exceptions.BadConsoleCommandException;
import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;

public class Console {
	//����, �� ����� ������ ����������� ��������� �������
	private LinkedHashMap<String, ConsoleCommand> items;
	
	/**
	 * � ����������� ������ ������� ������� ������ ������
	 * @param items ������ ����(�������)
	 */
	public Console(ConsoleCommand ... items) {
		this.items = new LinkedHashMap<>();
		//�������� ��� � ���
		for(ConsoleCommand item: items)
			this.items.put(item.getConsoleKey(), item);
	}
	
	/**
	 * ���� ������� ����� ����� (��������� ������������ ������)
	 * @param key ���� �������
	 * @return �� ����� �� ��������� �����
	 */
	public boolean select(String key) {
		//�������� � ���� ������� �� ����� �� �������� ��
		//���� �� ������� ������� - �������� ����� �������� �������
		
		String[] args = key.split(";");
		
		return items.getOrDefault(args[0], NULL).executeFromConsole(args);
	}
	
	//����� �������
	private static final ConsoleCommand NULL = new ConsoleCommand() {

		@Override
		public boolean executeFromConsole(String[] args) {
			throw new BadConsoleCommandException("Bad command ! Try again...");
		}

		@Override
		public String getConsoleKey() {
			return "";
		}

		@Override
		public String getSignature() {
			return "";
		}

	};
	
	public Collection<ConsoleCommand> getItems() {
		return items.values();
	}
	
	
}
