package com.epam.tgrynchuk.droids.model;


/**
 * @author Taras Grynchuk
 * 
 * <br><b>Клас Дроід</b><br>
 * 
 * @see com.epam.tgrynchuk.droids.model.Blaster
 * @see com.epam.tgrynchuk.droids.model.Droid
 * @see com.epam.tgrynchuk.droids.model.BattleRepairDroid
 * @see com.epam.tgrynchuk.droids.model.Army
 * @see com.epam.tgrynchuk.droids.model.Valuable
 * @see com.epam.tgrynchuk.droids.model.Repairer
 * 
 */
public abstract class Droid implements Valuable {
	//назва
	private String name;
	//поточний рівень здоров'я
	private int health;
	//броня
	private int armor;
	//бластер
	private Blaster blaster;
	
	public Blaster getBlaster() {
		return blaster;
	}

	public String getName() {
		return name + "(H = " + health + ")";
	}
	
	public int getHealth() {
		return health;
	}

	public int getArmor() {
		return armor;
	}
	
	/**
	 * @param name назва 
	 * @param armor броня
	 * @param blaster бластер
	 */
	public Droid(String name, int armor, Blaster blaster) {
		this.health = Constants.MAX_HEALTH;
		this.name = name;
		this.armor = armor;
		this.blaster = blaster;
	}	
		
	public Droid() {}
	
	/**
	 * Вартість дроіда в залежності від його параметрів, включаючи вартість його Бластера
	 */
	@Override
	public int getValue() {
		return 100 + 20 * armor + blaster.getValue();
	}
	
	@Override
	public String toString() {
		return name + "/ armor = " + armor + "/ health = " + health + " " + blaster + " Costs: " + getValue() +  " coins";
	}

	/**
	 * Чи можливо провести постріл
	 * @return так чи ні
	 */
	public boolean canShoot() {
		return blaster.canShoot();
	}

	/**
	 * Стріляти в задану мішень
	 * @param target мішень
	 */
	public void shoot(Droid target) {
		//стріляємо з Бластера
		blaster.shoot();
		//отримання пострілу дроідом ворога
		target.takeShoot(this);
	}
	
	/**
	 * Отримання постілу від ворога
	 * @param enemy ворожий дроід
	 */
	public void takeShoot(Droid enemy) {
		//забираємо життя, в залежності від потужності бластера ворога
		//та нашої броні
		health -= Math.max(enemy.getBlaster().getPower() - armor, 0);
		if(health < 0) health = 0;
	}
	
	/*
	 * Отримання ремонту від іншого дроіда
	 */
	public void takeRepair() {
		//збільшуємо рівень життя, але не більше, ніж максимально можливий
		health = Math.min(health + Constants.HEALTH_FOR_REPAIR, Constants.MAX_HEALTH);
	}
	
	/**
	 * Зарядка батареї бластера
	 */
	public void chargeBattery() {
		blaster.chargeBattery();
	}
	
	/**
	 * Чи ще живий
	 * @return так чи ні
	 */
	public boolean isAlive() {
		return health > 0;
	}
	
	/**
	 * Перевірка чи належать два дроіда до одної армії
	 * @param firstDroid перший дроїд
	 * @param secondDroid другий дроїд
	 * @param firstArmy перша армія
	 * @param secondArmy друга армія
	 * @return так чи ні
	 */
	public static boolean AreDroidsFriends(Droid firstDroid, Droid secondDroid, Army firstArmy, Army secondArmy) {
		if(firstArmy.contains(firstDroid) && firstArmy.contains(secondDroid)) return true;
		if(secondArmy.contains(firstDroid) && secondArmy.contains(secondDroid)) return true;
		return false;
	}
	
	/**
	 * Діяти
	 * @param ourArmy наша армія
	 * @param enemyArmy ворожа армія
	 * @return дроїд з яким ми взаємодіяли
	 */
	public abstract Droid act(Army ourArmy, Army enemyArmy);
}


