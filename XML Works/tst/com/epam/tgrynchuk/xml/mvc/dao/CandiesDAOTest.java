package com.epam.tgrynchuk.xml.mvc.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.epam.tgrynchuk.xml.Constants.*;



public class CandiesDAOTest {

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
		System.out.println("===============================================================================");
	}

	@Test
	public void test() {
		System.out.println(CandiesDAO.getAllCandies("DOMParser", INITAL_XML_PATH, INITAL_XSD_PATH));
	}

	@Test
	public void test2() {
		System.out.println(CandiesDAO.getAllCandies("SAXParser", INITAL_XML_PATH, INITAL_XSD_PATH));
	}
	
	@Test
	public void test3() {
		System.out.println(CandiesDAO.getAllCandies("STAXParser", INITAL_XML_PATH, INITAL_XSD_PATH));
	}


}
