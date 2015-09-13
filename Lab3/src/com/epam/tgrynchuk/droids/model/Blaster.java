package com.epam.tgrynchuk.droids.model;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>Клас Бластер</b><br>
 * 
 * @see com.epam.tgrynchuk.droids.model.BattleRepairDroid
 * @see com.epam.tgrynchuk.droids.model.Droid
 * @see com.epam.tgrynchuk.droids.model.BattleDroid
 * @see com.epam.tgrynchuk.droids.model.Army
 * @see com.epam.tgrynchuk.droids.model.Valuable
 * @see com.epam.tgrynchuk.droids.model.Repairer
 * 
 */
public class Blaster implements Valuable {
	//потужність
	private int power;
	//поточний рівень зарядки
	private int energy;
	//ємкість батареї
	private int batteryCapacity;
	
	public int getPower() {
		return power;
	}
	public int getEnergy() {
		return energy;
	}
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	
	/**
	 * @param power потужність
	 * @param batteryCapacity ємкість батареї
	 */
	public Blaster(int power, int batteryCapacity) {
		this.energy = batteryCapacity;
		this.power = power;
		this.batteryCapacity = batteryCapacity;
	}
	
	@SuppressWarnings("unused")
	private Blaster() {}
	
	@Override
	public String toString() {
		return "Blaster pow = " + power + "/ energy = " + energy;
	}
	
	/**
	 * Чи достатньо енергії для пострілу
	 * @return так чи ні
	 */
	public boolean canShoot() {
		if(energy >= Constants.ENERGY_FOR_SHOOT) return true;
		return false;
	}
	
	/**
	 * Стріляти
	 */
	public void shoot() {
		energy -= Constants.ENERGY_FOR_SHOOT;
		if(energy < 0) energy = 0;
	}
	
	/**
	 * Зарядити батарею
	 */
	public void chargeBattery() {
		energy = batteryCapacity;
	}
	
	/**
	 * вартість Бластера в залежності від його параметрів
	 * @return вартість
	 */
	@Override
	public int getValue() {
		return 50 + 15 * power + 3 * batteryCapacity;
	}
}
