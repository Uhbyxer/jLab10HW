package com.epam.tgrynchuk.droids.engine;

import java.util.concurrent.TimeUnit;

import com.epam.tgrynchuk.droids.engine.menus.*;
import com.epam.tgrynchuk.droids.engine.menus.commands.*;
import com.epam.tgrynchuk.droids.model.*;
import com.epam.tgrynchuk.droids.ui.*;

/**
 * @author Taras Grynchuk
 * <br><b>Основний контроллер програми</b><br>
 * Реалізація головного меню через класи: Menu, Command
 * 
 * @see com.epam.tgrynchuk.droids.engine.menus.Menu
 * @see com.epam.tgrynchuk.droids.engine.menus.Command

 * 
 */
public class BattleController {
	//консольне вікно програми
	private Window window;
	
	//Армії першого та другого гравців
	private Army firstPlayerArmy;
	private Army secondPlayerArmy; 
	
	public BattleController() {
		window = new Window();
	}
	
	/**
	 * Запуск контроллера
	 */
	public void run() {
		//створюємо головне меню
		Menu mainMenu = new Menu(
				//старт битви
				new StartTheBattleCommand(this),
				//вибір армії для першого гравця
				new ChooseFirstPlayerArmyCommand(this),
				//вибір армії для другого гравця
				new ChooseSecondPlayerArmyCommand(this),
				//вихід
				new QuitCommand()
	    );
		
		for(;;) {
			//key - клавіша, яку ввів користувач 
			String key = window.showMenu(mainMenu.getCommands());
			//виконнання команди, згідно натиснутої клавіші
			mainMenu.select(key);
		}
	}
	
	/**
	 * Старт битви
	 */	
	public void startTheBattle() {
		//перевірка чи були вже створені армії користувачів
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
			//затримка пограми
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//хід першого гравця
			firstAlive = firstPlayerArmy.getAliveDroids();
			if(firstAlive.isEmpty()) {
				//гру завершено
				window.showResults("Second player: " + secondPlayerArmy + " win !!!", secondPlayerArmy);
				break;
			} else {
				if(!(firstIndex < firstAlive.size())) firstIndex = 0;
				Droid droid = firstAlive.get(firstIndex);
				Droid otherDroid =  droid.act(firstPlayerArmy, secondPlayerArmy);
				//виводимо на екран
				window.showAction(droid, otherDroid);
			}
			
			//хід другого гравця
			secondAlive = secondPlayerArmy.getAliveDroids();
			if(secondAlive.isEmpty()) {
				//гру завершено
				window.showResults("First player: " + firstPlayerArmy + " win !!!", firstPlayerArmy);
				break;
			} else {
				if(!(secondIndex < secondAlive.size())) secondIndex = 0;
				Droid droid = secondAlive.get(secondIndex);
				Droid otherDroid =  droid.act(secondPlayerArmy, firstPlayerArmy);
				//виводимо на екран
				window.showAction(droid, otherDroid);
			}			
			
		}
		firstPlayerArmy = null;
		secondPlayerArmy = null;
	}
	
	/**
	 * Вибір першим гравцем своєї армії
	 */	
	public void chooseFirstPlayerArmy() {
		//створюємо меню для вибору
		Menu menu = new Menu(
				//вернутись у верхнє меню
				new GoBackCommand(),
				//обираємо перший варіант армії
				new FirstPlayerCreateFirstArmy(this),
				//обираємо другий варіант армії
				new FirstPlayerCreateSecondArmy(this),
				//обираємо третій варіант армії
				new FirstPlayerCreateThirdArmy(this)
	    );
		
		//key - клавіша, яку ввів користувач 
		String key = window.showMenu(menu.getCommands());
		//виконнання команди, згідно натиснутої клавіші
		menu.select(key);
	}
	
	/**
	 * Вибір другим гравцем своєї армії
	 */		
	public void chooseSecondPlayerArmy() {
		//створюємо меню для вибору
		Menu menu = new Menu(
				//вернутись у верхнє меню
				new GoBackCommand(),
				//обираємо перший варіант армії
				new SecondPlayerCreateFirstArmy(this),
				//обираємо другий варіант армії
				new SecondPlayerCreateSecondArmy(this),
				//обираємо третій варіант армії
				new SecondPlayerCreateThirdArmy(this)
	    );
		
		//key - клавіша, яку ввів користувач 
		String key = window.showMenu(menu.getCommands());
		//виконнання команди, згідно натиснутої клавіші
		menu.select(key);
	}	
	
	/**
	 * Для першого гравця створюємо перший варіант армії
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
	 * Для першого гравця створюємо другий варіант армії
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
	 * Для першого гравця створюємо трктій варіант армії
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
	 * Для другого гравця створюємо перший варіант армії
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
	 * Для другого гравця створюємо другий варіант армії
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
	 * Для другого гравця створюємо трктій варіант армії
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

