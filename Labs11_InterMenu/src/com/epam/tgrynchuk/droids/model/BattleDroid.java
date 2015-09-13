package com.epam.tgrynchuk.droids.model;

import java.util.Random;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>Клас Бойовий Дроід</b><br>
 * 
 * @see com.epam.tgrynchuk.droids.model.Blaster
 * @see com.epam.tgrynchuk.droids.model.Droid
 * @see com.epam.tgrynchuk.droids.model.BattleRepairDroid
 * @see com.epam.tgrynchuk.droids.model.Army
 * @see com.epam.tgrynchuk.droids.model.Valuable
 * @see com.epam.tgrynchuk.droids.model.Repairer
 * 
 */
public class BattleDroid extends Droid {
	
	public BattleDroid(String name, int armor, Blaster blaster) {
		super(name, armor, blaster);
	}
	
	@SuppressWarnings("unused")
	private BattleDroid() {}

	/**
	 * Діяти (стріляти/заряджати батарею бластера)
	 * @param ourArmy наша армія
	 * @param enemyArmy армія ворога
	 * @return якщо стріляли в ворога - ссилка на відповідного дроіда, інакше - ссилка на себе
	 */
	@Override
	public Droid act(Army ourArmy, Army enemyArmy) {
		//нема енергії
		if(!canShoot()) {
			//зараджаємо батарею
			chargeBattery();
			return null;
		}
		
		//отримуємо можливі мішені з живих дроідів ворога
		Army targets = enemyArmy.getAliveDroids();
		//нема по кому стріляти - всі мертві
		if(targets.isEmpty()) return null;
		
		//обираємо мішень навмання
		Droid enemy = targets.get(rand.nextInt(targets.size()));
		//стріляємо
		shoot(enemy);
		return enemy;
	}
	
	@Override
	public String toString() {
		return "Battle " + super.toString();
	}
	
	private Random rand = new Random();
}
