package com.epam.tgrynchuk.jewelry.utils;



import java.lang.reflect.*;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.exceptions.ClientNewInstanceException;
import com.epam.tgrynchuk.jewelry.exceptions.StoneNewInstanceException;
import com.epam.tgrynchuk.jewelry.mvc.models.Client;
import com.epam.tgrynchuk.jewelry.mvc.models.Stone;
import com.epam.tgrynchuk.jewelry.mvc.ui.Window;

public class Reflection {
	private static final Logger LOGGER = Logger.getLogger(Reflection.class);
	
	public static Stone newInstanceOfStone(String className, int id, double value, double weight) {
		LOGGER.trace("newInstanceOfStone --> " + className);
		Stone instance = null;
		try {
			Class<?> clazz = Class.forName(className);
			
			Constructor<?> constructor = clazz.getConstructor(int.class, double.class, double.class);
			instance = (Stone) constructor.newInstance(id, value, weight);
			LOGGER.trace("constructor.newInstance id = " + id);
		
		} catch(ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException  e) {
			throw new StoneNewInstanceException("Помилка створення екземпляра: " + className, e);
		}
		
		return instance;
	}
	
	public static Client newInstanceOfClient(String name, int age, boolean isMale) {
		LOGGER.trace("newInstanceOfStone --> " + name);
		String className = "com.epam.tgrynchuk.jewelry.mvc.models.Client";
		Client instance = null;
		try {
			Class<?> clazz = Class.forName(className);
			
			Constructor<?> constructor = clazz.getConstructor(String.class, int.class, boolean.class);
			instance = (Client) constructor.newInstance(name, age, isMale);
			LOGGER.trace("newInstance " + name);
		
		} catch(ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException  e) {
			throw new ClientNewInstanceException("Помилка створення екземпляра: " + className, e);
		}
		
		return instance;
	}}


