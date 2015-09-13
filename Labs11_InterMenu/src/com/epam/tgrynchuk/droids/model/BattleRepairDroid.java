package com.epam.tgrynchuk.droids.model;

import java.util.Random;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>���� ������� ����, ���� �쳺 �����������</b><br>
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
	 * @param name �����
	 * @param armor �����
	 * @param blaster �������
	 */
	public BattleRepairDroid(String name, int armor, Blaster blaster) {
		super(name, armor, blaster);
	}
	
	@SuppressWarnings("unused")
	private BattleRepairDroid() {}

	/**
	 * �� ������� �������� ������ ����� �� ��������
	 * @param index ������ ����� ��� �������
	 * @param friends ���� ����
	 * @return ���� ������� - ������ �� ��������������� �����, ������ - null
	 */
	private Droid CanRepairByIndex(int index, Army friends) {
		Droid result = null;
		
		//������ ����������� ����� ����� ���� �� ������
		//� ����� ����� ����� ������ �� 60%
		if(index>= 0 && index < friends.size()) 
			if(100 * friends.get(index).getHealth() / Constants.MAX_HEALTH <  60)
				result = friends.get(index);
		
		return result;
	}
	
	/**
	 * ĳ��� (�������/�����������/��������� ������� ��������)
	 * @param ourArmy ���� ����
	 * @param enemyArmy ���� ������
	 * @return ���� ������� � ������ - ������ �� ���������� �����, 
	 * ���� ����������� ����� - ������ �� �����,
	 * ������ - ������ �� ����
	 */
	@Override
	public Droid act(Army ourArmy, Army enemyArmy) {
		//�������� �������� ������������� ����� ��� ������� �����, ���� �������
		//����������� < 60%, ������ ��������
		Army friends = ourArmy.getAliveDroids();
		int index = friends.indexOf(this);
		Droid friendToRepair = null;
		//���� 
		friendToRepair = CanRepairByIndex(index - 1, friends);
		//������
		if(friendToRepair == null) friendToRepair = CanRepairByIndex(index + 1, friends);
		
		if(friendToRepair != null) {
			//��������� �� ��������
			repair(friendToRepair);
			return friendToRepair;
		}
		//���� ���� ����������� - ������ �������
		
		//���� ����㳿
		if(!canShoot()) {
			//������ ��������� �������
			chargeBattery();
			return null;
		}
		
		//��������
		Army targets = enemyArmy.getAliveDroids();
		//���� �� ���� ������� - �� �����
		if(targets.isEmpty()) return null;
				
		Droid enemy = targets.get(rand.nextInt(targets.size()));
		shoot(enemy);
		return enemy;
	}
	
	/**
	 * ������� ������ �����
	 * @param droid ���� ����� ������ �����������
	 */
	@Override
	public void repair(Droid droid) {
		//��������� ������� �� ������ �����
		droid.takeRepair();
	}
	
	/**
	 * ������� �����
	 * @return ������� 
	 */
	@Override
	public int getValue() {
		//�� �������� ������� ����� ������ �� � ������� �� ��������� �����������
		return super.getValue() + 100;
	}
	
	@Override
	public String toString() {
		return "Repair " + super.toString();
	}
	
	private Random rand = new Random();
	
}
