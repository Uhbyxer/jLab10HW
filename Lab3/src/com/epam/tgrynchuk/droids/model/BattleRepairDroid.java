package com.epam.tgrynchuk.droids.model;

import java.util.Random;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>Клас Бойовий Дроід, який вміє ремонтувати</b><br>
 * 
 * @see com.epam.tgrynchuk.droids.model.Blaster
 * @see com.epam.tgrynchuk.droids.model.Droid
 * @see com.epam.tgrynchuk.droids.model.BattleDroid
 * @see com.epam.tgrynchuk.droids.model.Army
 * @see com.epam.tgrynchuk.droids.model.Valuable
 * @see com.epam.tgrynchuk.droids.model.Repairer
 * 
 */
public class BattleRepairDroid extends Droid implements Repairer {

	/**
	 * @param name назва
	 * @param armor броня
	 * @param blaster бластер
	 */
	public BattleRepairDroid(String name, int armor, Blaster blaster) {
		super(name, armor, blaster);
	}
	
	@SuppressWarnings("unused")
	private BattleRepairDroid() {}

	/**
	 * Чи можливо провести ремонт дроіда за індексом
	 * @param index індекс дроіда для ремонту
	 * @param friends наша армія
	 * @return якщо можливо - ссилка на відремонтованого дроіда, інакше - null
	 */
	private Droid CanRepairByIndex(int index, Army friends) {
		Droid result = null;
		
		//можемо ремонтувати тільки сусіда зліва чи справа
		//в якого рівень життя нижчий за 60%
		if(index>= 0 && index < friends.size()) 
			if(100 * friends.get(index).getHealth() / Constants.MAX_HEALTH <  60)
				result = friends.get(index);
		
		return result;
	}
	
	/**
	 * Діяти (стріляти/ремонтувати/заряджати батарею бластера)
	 * @param ourArmy наша армія
	 * @param enemyArmy армія ворога
	 * @return якщо стріляли в ворога - ссилка на відповідного дроіда, 
	 * якщо ремонтували друга - ссилка на нього,
	 * інакше - ссилка на себе
	 */
	@Override
	public Droid act(Army ourArmy, Army enemyArmy) {
		//спочатку спробуємо відремонтувати лівого або правого сусіда, якщо процент
		//пошкодження < 60%, інакше стріляємо
		Army friends = ourArmy.getAliveDroids();
		int index = friends.indexOf(this);
		Droid friendToRepair = null;
		//лівий 
		friendToRepair = CanRepairByIndex(index - 1, friends);
		//правий
		if(friendToRepair == null) friendToRepair = CanRepairByIndex(index + 1, friends);
		
		if(friendToRepair != null) {
			//ремонтуємо та виходимо
			repair(friendToRepair);
			return friendToRepair;
		}
		//нема кого ремонтувати - будемо стріляти
		
		//нема енергії
		if(!canShoot()) {
			//просто заряджаємо батарею
			chargeBattery();
			return null;
		}
		
		//стліляємо
		Army targets = enemyArmy.getAliveDroids();
		//нема по кому стріляти - всі мертві
		if(targets.isEmpty()) return null;
				
		Droid enemy = targets.get(rand.nextInt(targets.size()));
		shoot(enemy);
		return enemy;
	}
	
	/**
	 * ремонту іншого дроіда
	 * @param droid дроід якого будемо ремонтувати
	 */
	@Override
	public void repair(Droid droid) {
		//отримання ремонту від іншого дроіда
		droid.takeRepair();
	}
	
	/**
	 * вартість дроіда
	 * @return вартість 
	 */
	@Override
	public int getValue() {
		//до загальної вартості дроіда додамо ще й вартість за можливість ремонтувати
		return super.getValue() + 100;
	}
	
	@Override
	public String toString() {
		return "Repair " + super.toString();
	}
	
	private Random rand = new Random();
	
}
