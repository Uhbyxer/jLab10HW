package com.epam.tgrynchuk.xml;

import java.io.*;

import javax.xml.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

import org.xml.sax.SAXException;

public class XMLValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	     System.out.println("Validate: "+validateXMLSchema(".\\univer.xsd", ".\\univer.xml"));


	}
	
    public static boolean validateXMLSchema(String xsdPath, String xmlPath){
        
        try {
            SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }

}
