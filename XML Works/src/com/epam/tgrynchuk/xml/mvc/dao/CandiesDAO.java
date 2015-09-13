package com.epam.tgrynchuk.xml.mvc.dao;

import java.io.File;

import com.epam.tgrynchuk.xml.mvc.models.Candies;
import com.epam.tgrynchuk.xml.utils.AbstractXMLParser;

public class CandiesDAO {
	public static Candies getAllCandies(String parserName, File xmlPath, File xsdPath) {
		Candies candies = new Candies();
		
		AbstractXMLParser parser = AbstractXMLParser.newInstance(parserName);
		parser.setXmlPath(xmlPath);
		parser.setXsdPath(xsdPath);
		
		boolean success =  parser.parseIfValid(candies);
		
		if(!success)
			return null;
		
		return candies;

	}
	
	public static Candies getAllCandies(String parserName, String xmlPath, String xsdPath) {
		return getAllCandies(parserName, new File(xmlPath), new File(xsdPath));
	}
}
