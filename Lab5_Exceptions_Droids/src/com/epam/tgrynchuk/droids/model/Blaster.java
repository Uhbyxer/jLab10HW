package com.epam.tgrynchuk.droids.model;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>���� �������</b><br>
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
	//���������
	private int power;
	//�������� ����� �������
	private int energy;
	//������ ������
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
	 * @param power ���������
	 * @param batteryCapacity ������ ������
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
	 * �� ��������� ����㳿 ��� �������
	 * @return ��� �� �
	 */
	public boolean canShoot() {
		if(energy >= Constants.ENERGY_FOR_SHOOT) return true;
		return false;
	}
	
	/**
	 * �������
	 */
	public void shoot() {
		energy -= Constants.ENERGY_FOR_SHOOT;
		if(energy < 0) energy = 0;
	}
	
	/**
	 * �������� �������
	 */
	public void chargeBattery() {
		energy = batteryCapacity;
	}
	
	/**
	 * ������� �������� � ��������� �� ���� ���������
	 * @return �������
	 */
	@Override
	public int getValue() {
		return 50 + 15 * power + 3 * batteryCapacity;
	}
}
