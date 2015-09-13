package com.epam.lab10;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcTest {
	private static Calc calc;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		calc = new Calc();
		System.out.println("Class created");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test()
	public void testPlus() {
		System.out.println("test plus");
		int s = calc.plus(4, 10);
		assertEquals(s, 14);
	}

	@Test
	public void testMinus() {
		assertTrue(calc.minus(5, 2) == 3);
	}

	@Test
	public void testToString() {
		assertNotNull(calc.toString());
	}

}
