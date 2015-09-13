package com.epam.tgrynchuk.jewelry.mvc.models;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>Інтерфейс Здатність до оцінки вартості</b>
 * 
 */
public interface Valuable {
	/**
	 * отримати вартість
	 * @return вартість
	 */
	double getValue();
	double getWeight();
}
