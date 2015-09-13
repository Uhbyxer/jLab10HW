package com.epam.tgrynchuk.xml.utils;

import java.io.File;


import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import com.epam.tgrynchuk.xml.mvc.models.Candies;

public abstract class AbstractXMLParser {
	protected File xsdPath, xmlPath;

	
	public AbstractXMLParser() {
	}	
	
	public AbstractXMLParser(File xsdPath) {
		super();
		this.xsdPath = xsdPath;
	}
	
	public AbstractXMLParser(String xsdPath) {
		this(new File(xsdPath));
	}

	public File getXsdPath() {
		return xsdPath;
	}

	public File getXmlPath() {
		return xmlPath;
	}

	public void setXsdPath(File xsdPath) {
		this.xsdPath = xsdPath;
	}

	public void setXsdPath(String xsdPath) {
		setXsdPath(new File(xsdPath));
	}

	public void setXmlPath(File xmlPath) {
		this.xmlPath = xmlPath;
	}
	
	public void setXmlPath(String xmlPath) {
		setXmlPath(new File(xmlPath));
	}
	
	public static AbstractXMLParser newInstance(String className) throws RuntimeException {
		
		try {
			Class<?> cls = Class.forName("com.epam.tgrynchuk.xml.utils." + className);
			
			return (AbstractXMLParser) cls.newInstance();
		
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static boolean isValid(File xml, File xsd) {
		try {
			
            SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            
			return true;
		} catch(Exception e) {
			
		}
		
		return false;
	}
	
	public static boolean isValid(String xml, String xsd) {
		return isValid(new File(xml), new File(xsd));
	}
	
	public boolean isValid() {
		return isValid(this.xmlPath, this.xsdPath);
	}
	
	
	
	public boolean parseIfValid(Candies candies) {
		if(!isValid()) 
			return false;
		
		try {
			parse(candies);
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	protected abstract boolean parse(Candies candies) throws Exception;		
}
