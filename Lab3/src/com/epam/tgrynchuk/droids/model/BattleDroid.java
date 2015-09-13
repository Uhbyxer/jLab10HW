package com.epam.tgrynchuk.droids.model;

import java.util.Random;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>���� ������� ����</b><br>
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
	 * ĳ��� (�������/��������� ������� ��������)
	 * @param ourArmy ���� ����
	 * @param enemyArmy ���� ������
	 * @return ���� ������� � ������ - ������ �� ���������� �����, ������ - ������ �� ����
	 */
	@Override
	public Droid act(Army ourArmy, Army enemyArmy) {
		//���� ����㳿
		if(!canShoot()) {
			//��������� �������
			chargeBattery();
			return null;
		}
		
		//�������� ������ ���� � ����� ����� ������
		Army targets = enemyArmy.getAliveDroids();
		//���� �� ���� ������� - �� �����
		if(targets.isEmpty()) return null;
		
		//������� ����� ��������
		Droid enemy = targets.get(rand.nextInt(targets.size()));
		//��������
		shoot(enemy);
		return enemy;
	}
	
	@Override
	public String toString() {
		return "Battle " + super.toString();
	}
	
	private Random rand = new Random();
}
