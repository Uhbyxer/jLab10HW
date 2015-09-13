package com.epam.tgrynchuk.droids.model;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>Інтерфейс Здатність до ремонту</b>
 * 
 */
public interface Repairer {
	/**
	 * Ремонтувати
	 * @param droid дроід, якого будемо ремонтувати
	 */
	public void repair(Droid droid);
}
