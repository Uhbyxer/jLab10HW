package com.epam.tgrynchuk.xml.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.tgrynchuk.xml.Constants;
import com.epam.tgrynchuk.xml.mvc.models.Candies;
import com.sun.corba.se.impl.orbutil.closure.Constant;

public class DOMParserTest {

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
		
		AbstractXMLParser parser = new DOMParser(Constants.INITAL_XSD_PATH);
		parser.setXmlPath(Constants.INITAL_XML_PATH);
		
		Candies candies = new Candies(); 
		boolean res = parser.isValid();
		
		
		System.out.println(res);
		
		parser.parseIfValid(candies);
		System.out.println(candies);
		
	}

}
