package com.epam.tgrynchuk.droids.model;

import java.util.LinkedList;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>���� ���� �����</b><br>
 * 
 * @see com.epam.tgrynchuk.droids.model.Droid
 * @see com.epam.tgrynchuk.droids.model.Blaster
 * @see com.epam.tgrynchuk.droids.model.BattleDroid
 * @see com.epam.tgrynchuk.droids.model.BattleRepairDroid
 * @see com.epam.tgrynchuk.droids.model.Valuable
 * @see com.epam.tgrynchuk.droids.model.Repairer
 * 
 */
public class Army extends LinkedList<Droid> implements Valuable {
	//����� ��쳿
	private String name; 
	
	public Army(String name) {
		super();
		this.name = name;
	}
	
	public Army() {}

	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * �������� ����� �����
	 * @return ���� ����� �����
	 */
	public Army getAliveDroids() {
		Army aliveDroids = new Army();
		for(Droid d: this)
			if(d.isAlive()) aliveDroids.add(d);
		return aliveDroids;
	}
	
	/**
	 * ������� ��쳿
	 */
	@Override
	public int getValue() {
		int result = 0;
		for(Droid droid: this) result += droid.getValue(); 
		return result;
	}
	
	private static final long serialVersionUID = 1L;

	
}
