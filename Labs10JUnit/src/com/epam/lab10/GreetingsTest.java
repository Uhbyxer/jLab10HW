package com.epam.lab10;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;



public class GreetingsTest {
	private static final Logger LOGGER = Logger.getLogger(GreetingsTest.class);
	Greetings g;
	
	@Before
	public void init() {
		g = new Greetings();
		LOGGER.debug("init");
	}
	
	@Test
	public void testSayHello() {
		
		boolean cond = "Hellov".equals(g.sayHello());
		LOGGER.assertLog(cond, "not hello");
		assertTrue(cond);
		
		
		
	}
	
	@Test
	public void testPrivateMeth() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method method = Greetings.class.getDeclaredMethod("getPassword", int.class);
		method.setAccessible(true);
		String res = (String) method.invoke(g, 5);
		assertEquals("5", res);
		
	}
	
	@Test
	public void testNewFile() throws IOException {
		String fileName = "test.txt";
		g.newFile(fileName);
		assertTrue(new File(fileName).exists());
	}
}
