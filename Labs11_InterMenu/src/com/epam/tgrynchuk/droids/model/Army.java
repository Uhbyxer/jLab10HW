package com.epam.tgrynchuk.droids.model;

import java.util.LinkedList;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>Клас Армія Дроідів</b><br>
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
	//назва армії
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
	 * Отримати живих дроідів
	 * @return армія живих дроідів
	 */
	public Army getAliveDroids() {
		Army aliveDroids = new Army();
		for(Droid d: this)
			if(d.isAlive()) aliveDroids.add(d);
		return aliveDroids;
	}
	
	/**
	 * Вартість армії
	 */
	@Override
	public int getValue() {
		int result = 0;
		for(Droid droid: this) result += droid.getValue(); 
		return result;
	}
	
	private static final long serialVersionUID = 1L;

	
}
