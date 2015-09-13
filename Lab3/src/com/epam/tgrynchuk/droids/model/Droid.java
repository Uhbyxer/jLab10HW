package com.epam.tgrynchuk.droids.model;


/**
 * @author Taras Grynchuk
 * 
 * <br><b>���� ����</b><br>
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
	//�����
	private String name;
	//�������� ����� ������'�
	private int health;
	//�����
	private int armor;
	//�������
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
	 * @param name ����� 
	 * @param armor �����
	 * @param blaster �������
	 */
	public Droid(String name, int armor, Blaster blaster) {
		this.health = Constants.MAX_HEALTH;
		this.name = name;
		this.armor = armor;
		this.blaster = blaster;
	}	
		
	public Droid() {}
	
	/**
	 * ������� ����� � ��������� �� ���� ���������, ��������� ������� ���� ��������
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
	 * �� ������� �������� ������
	 * @return ��� �� �
	 */
	public boolean canShoot() {
		return blaster.canShoot();
	}

	/**
	 * ������� � ������ �����
	 * @param target �����
	 */
	public void shoot(Droid target) {
		//�������� � ��������
		blaster.shoot();
		//��������� ������� ������ ������
		target.takeShoot(this);
	}
	
	/**
	 * ��������� ������ �� ������
	 * @param enemy ������� ����
	 */
	public void takeShoot(Droid enemy) {
		//�������� �����, � ��������� �� ��������� �������� ������
		//�� ���� ����
		health -= Math.max(enemy.getBlaster().getPower() - armor, 0);
		if(health < 0) health = 0;
	}
	
	/*
	 * ��������� ������� �� ������ �����
	 */
	public void takeRepair() {
		//�������� ����� �����, ��� �� �����, �� ����������� ��������
		health = Math.min(health + Constants.HEALTH_FOR_REPAIR, Constants.MAX_HEALTH);
	}
	
	/**
	 * ������� ������ ��������
	 */
	public void chargeBattery() {
		blaster.chargeBattery();
	}
	
	/**
	 * �� �� �����
	 * @return ��� �� �
	 */
	public boolean isAlive() {
		return health > 0;
	}
	
	/**
	 * �������� �� �������� ��� ����� �� ���� ��쳿
	 * @param firstDroid ������ ����
	 * @param secondDroid ������ ����
	 * @param firstArmy ����� ����
	 * @param secondArmy ����� ����
	 * @return ��� �� �
	 */
	public static boolean AreDroidsFriends(Droid firstDroid, Droid secondDroid, Army firstArmy, Army secondArmy) {
		if(firstArmy.contains(firstDroid) && firstArmy.contains(secondDroid)) return true;
		if(secondArmy.contains(firstDroid) && secondArmy.contains(secondDroid)) return true;
		return false;
	}
	
	/**
	 * ĳ���
	 * @param ourArmy ���� ����
	 * @param enemyArmy ������ ����
	 * @return ���� � ���� �� ���������
	 */
	public abstract Droid act(Army ourArmy, Army enemyArmy);
}


