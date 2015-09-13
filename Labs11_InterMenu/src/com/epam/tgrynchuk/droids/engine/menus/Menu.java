package com.epam.tgrynchuk.droids.engine.menus;

import java.util.Collection;

import java.util.LinkedHashMap;

/**
 * @author Taras Grynchuk
 * <br><b>���� ����</b><br>
 *
 * @see com.epam.tgrynchuk.droids.engine.menus.Command
 */
public class Menu {
	//����, �� ����� ������ ����������� ���������� ����� ����
	private LinkedHashMap<String, Command> commands;
	
	/**
	 * � ����������� ������ ������� ������� ������ ������
	 * @param commands ������ ����(�������)
	 */
	public Menu(Command ... commands) {
		this.commands = new LinkedHashMap<>();
		//�������� ��� � ���
		for(Command com: commands)
			this.commands.put(com.getKey(), com);
	}
	
	/**
	 * ���� ������� ����� ����� (��������� ������������ ������)
	 * @param key ���� �������
	 */
	public void select(String key) {
		//�������� � ���� ������� �� ����� �� �������� ��
		//���� �� ������� ������� - �������� ����� �������� �������
		commands.getOrDefault(key, NULL).execute();
	}
	
	//����� �������
	private static final Command NULL = new Command() {
		
		@Override
		public String getKey() {
			return "";
		}
		
		@Override
		public void execute() {
		}


	};
	
	/**
	 * �������� �������� ������ � ����
	 * @return �������� ������� ������
	 */
	public Collection<? extends Object> getCommands() {
		return commands.values();
	}
}
