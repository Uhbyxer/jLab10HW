package com.epam.tgrynchuk.droids.engine;

import java.util.concurrent.TimeUnit;

import com.epam.tgrynchuk.droids.engine.menus.*;
import com.epam.tgrynchuk.droids.engine.menus.commands.*;
import com.epam.tgrynchuk.droids.model.*;
import com.epam.tgrynchuk.droids.ui.*;

/**
 * @author Taras Grynchuk
 * <br><b>�������� ���������� ��������</b><br>
 * ��������� ��������� ���� ����� �����: Menu, Command
 * 
 * @see com.epam.tgrynchuk.droids.engine.menus.Menu
 * @see com.epam.tgrynchuk.droids.engine.menus.Command

 * 
 */
public class BattleController {
	//��������� ���� ��������
	private Window window;
	
	//��쳿 ������� �� ������� �������
	private Army firstPlayerArmy;
	private Army secondPlayerArmy; 
	
	public BattleController() {
		window = new Window();
	}
	
	/**
	 * ������ �����������
	 */
	public void run() {
		//��������� ������� ����
		Menu mainMenu = new Menu(
				//����� �����
				new StartTheBattleCommand(this),
				//���� ��쳿 ��� ������� ������
				new ChooseFirstPlayerArmyCommand(this),
				//���� ��쳿 ��� ������� ������
				new ChooseSecondPlayerArmyCommand(this),
				//�����
				new QuitCommand()
	    );
		
		for(;;) {
			//key - ������, ��� ��� ���������� 
			String key = window.showMenu(mainMenu.getCommands());
			//���������� �������, ����� ��������� ������
			mainMenu.select(key);
		}
	}
	
	/**
	 * ����� �����
	 */	
	public void startTheBattle() {
		//�������� �� ���� ��� ������� ��쳿 ������������
		if(firstPlayerArmy == null) {
			window.showError("\n!!!!!!!!!! First player army is empty !!!!!!!!!!!");
			return;
		}
		if(secondPlayerArmy == null) {
			window.showError("\n!!!!!!!!!! Second player army is empty !!!!!!!!!!!");
			return;
		}
		
		Army firstAlive = null;
		Army secondAlive = null;
		int firstIndex = 0, secondIndex = 0;
		
		for(firstIndex = 0, secondIndex = 0; ; firstIndex++, secondIndex++) {
			//�������� �������
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//��� ������� ������
			firstAlive = firstPlayerArmy.getAliveDroids();
			if(firstAlive.isEmpty()) {
				//��� ���������
				window.showResults("Second player: " + secondPlayerArmy + " win !!!", secondPlayerArmy);
				break;
			} else {
				if(!(firstIndex < firstAlive.size())) firstIndex = 0;
				Droid droid = firstAlive.get(firstIndex);
				Droid otherDroid =  droid.act(firstPlayerArmy, secondPlayerArmy);
				//�������� �� �����
				window.showAction(droid, otherDroid);
			}
			
			//��� ������� ������
			secondAlive = secondPlayerArmy.getAliveDroids();
			if(secondAlive.isEmpty()) {
				//��� ���������
				window.showResults("First player: " + firstPlayerArmy + " win !!!", firstPlayerArmy);
				break;
			} else {
				if(!(secondIndex < secondAlive.size())) secondIndex = 0;
				Droid droid = secondAlive.get(secondIndex);
				Droid otherDroid =  droid.act(secondPlayerArmy, firstPlayerArmy);
				//�������� �� �����
				window.showAction(droid, otherDroid);
			}			
			
		}
		firstPlayerArmy = null;
		secondPlayerArmy = null;
	}
	
	/**
	 * ���� ������ ������� �� ��쳿
	 */	
	public void chooseFirstPlayerArmy() {
		//��������� ���� ��� ������
		Menu menu = new Menu(
				//��������� � ����� ����
				new GoBackCommand(),
				//������� ������ ������ ��쳿
				new FirstPlayerCreateFirstArmy(this),
				//������� ������ ������ ��쳿
				new FirstPlayerCreateSecondArmy(this),
				//������� ����� ������ ��쳿
				new FirstPlayerCreateThirdArmy(this)
	    );
		
		//key - ������, ��� ��� ���������� 
		String key = window.showMenu(menu.getCommands());
		//���������� �������, ����� ��������� ������
		menu.select(key);
	}
	
	/**
	 * ���� ������ ������� �� ��쳿
	 */		
	public void chooseSecondPlayerArmy() {
		//��������� ���� ��� ������
		Menu menu = new Menu(
				//��������� � ����� ����
				new GoBackCommand(),
				//������� ������ ������ ��쳿
				new SecondPlayerCreateFirstArmy(this),
				//������� ������ ������ ��쳿
				new SecondPlayerCreateSecondArmy(this),
				//������� ����� ������ ��쳿
				new SecondPlayerCreateThirdArmy(this)
	    );
		
		//key - ������, ��� ��� ���������� 
		String key = window.showMenu(menu.getCommands());
		//���������� �������, ����� ��������� ������
		menu.select(key);
	}	
	
	/**
	 * ��� ������� ������ ��������� ������ ������ ��쳿
	 */	
	public void firstPlayerCreateFirstArmy() {
		firstPlayerArmy = new Army("7 Jedis");
		firstPlayerArmy.add(new BattleDroid("Jedi's droid #1", 2, new Blaster(6, 25)));
		firstPlayerArmy.add(new BattleRepairDroid("Jedi's droid #2", 3, new Blaster(6, 25)));
		firstPlayerArmy.add(new BattleDroid("Jedi's droid #3", 1, new Blaster(5, 20)));
		firstPlayerArmy.add(new BattleDroid("Jedi's droid #4", 5, new Blaster(8, 16)));
		firstPlayerArmy.add(new BattleDroid("Jedi's droid #5", 2, new Blaster(6, 25)));
		firstPlayerArmy.add(new BattleRepairDroid("Jedi's droid #6", 2, new Blaster(9, 40)));
		firstPlayerArmy.add(new BattleRepairDroid("Jedi's droid #8", 2, new Blaster(9, 40)));	
		
		window.init(firstPlayerArmy, secondPlayerArmy);	
	}
	
	/**
	 * ��� ������� ������ ��������� ������ ������ ��쳿
	 */	
	public void firstPlayerCreateSecondArmy() {
		firstPlayerArmy = new Army("5 Jedi's");
		firstPlayerArmy.add(new BattleDroid("Jedi's droid #1", 3, new Blaster(8, 35)));
		firstPlayerArmy.add(new BattleRepairDroid("Jedi's droid #2", 5, new Blaster(5, 15)));
		firstPlayerArmy.add(new BattleDroid("Jedi's droid #3", 3, new Blaster(8, 35)));
		firstPlayerArmy.add(new BattleRepairDroid("Jedi's droid #4", 5, new Blaster(5, 15)));
		firstPlayerArmy.add(new BattleDroid("Jedi's droid #5", 3, new Blaster(8, 35)));	
		
		window.init(firstPlayerArmy, secondPlayerArmy);	
	}

	/**
	 * ��� ������� ������ ��������� ����� ������ ��쳿
	 */	
	public void firstPlayerCreateThirdArmy() {
		firstPlayerArmy = new Army("Gang of fourth");
		firstPlayerArmy.add(new BattleDroid("GOF #1", 0, new Blaster(15, 50)));
		firstPlayerArmy.add(new BattleRepairDroid("GOF #2", 0, new Blaster(15, 50)));
		firstPlayerArmy.add(new BattleDroid("GOF #3", 0, new Blaster(15, 50)));	
		firstPlayerArmy.add(new BattleDroid("GOF #4", 0, new Blaster(15, 50)));
		
		window.init(firstPlayerArmy, secondPlayerArmy);	
	}
	
	/**
	 * ��� ������� ������ ��������� ������ ������ ��쳿
	 */	
	public void secondPlayerCreateFirstArmy() {
		secondPlayerArmy = new Army("7 Siths");
		secondPlayerArmy.add(new BattleDroid("Sith's droid #1", 3, new Blaster(6, 35)));
		secondPlayerArmy.add(new BattleRepairDroid("Sith's droid #2", 5, new Blaster(5, 15)));
		secondPlayerArmy.add(new BattleDroid("Sith's droid #3", 3, new Blaster(6, 35)));
		secondPlayerArmy.add(new BattleRepairDroid("Sith's droid #4", 5, new Blaster(5, 15)));
		secondPlayerArmy.add(new BattleDroid("Sith's droid #5", 3, new Blaster(6, 35)));
		secondPlayerArmy.add(new BattleRepairDroid("Sith's droid #6", 5, new Blaster(5, 15)));	
		secondPlayerArmy.add(new BattleDroid("Sith's droid #7", 3, new Blaster(6, 35)));
		
		window.init(firstPlayerArmy, secondPlayerArmy);	
	}
	
	/**
	 * ��� ������� ������ ��������� ������ ������ ��쳿
	 */	
	public void secondPlayerCreateSecondArmy() {
		secondPlayerArmy = new Army("5 Siths");
		secondPlayerArmy.add(new BattleRepairDroid("Sith's droid #2", 5, new Blaster(5, 15)));
		secondPlayerArmy.add(new BattleRepairDroid("Sith's droid #4", 5, new Blaster(5, 15)));
		secondPlayerArmy.add(new BattleRepairDroid("Sith's droid #6", 5, new Blaster(5, 15)));	
		secondPlayerArmy.add(new BattleDroid("Sith's droid #3", 3, new Blaster(6, 35)));
		secondPlayerArmy.add(new BattleDroid("Sith's droid #1", 3, new Blaster(6, 35)));	
		
		window.init(firstPlayerArmy, secondPlayerArmy);	
	}
	
	/**
	 * ��� ������� ������ ��������� ����� ������ ��쳿
	 */	
	public void secondPlayerCreateThirdArmy() {
		secondPlayerArmy = new Army("The Beatles");
		secondPlayerArmy.add(new BattleDroid("Paul Mc Cartney", 0, new Blaster(15, 50)));
		secondPlayerArmy.add(new BattleRepairDroid("George Harrison", 0, new Blaster(15, 50)));
		secondPlayerArmy.add(new BattleDroid("John Lennon", 0, new Blaster(15, 50)));	
		secondPlayerArmy.add(new BattleDroid("Ringo Starr", 0, new Blaster(15, 50)));
		
		window.init(firstPlayerArmy, secondPlayerArmy);	
	}
	

}

