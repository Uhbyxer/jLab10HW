package com.epam.tgrynchuk.xml.mvc.dto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IngredientDTOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		IngredientDTO x = new IngredientDTO("aaa", 5);
		IngredientDTO y = new IngredientDTO("aaa", 4);
		
		boolean foo = x.equals(y);
		
		System.out.println(foo);
		
		assertEquals(x, y);
	}

}
