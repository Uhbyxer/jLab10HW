package com.epam.tgrynchuk.xml;

import java.io.*;

import javax.xml.bind.Element;
import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile {

	public static void main(String[] args) {
		
	    try {
	    	 
	    	File fXmlFile = new File("./univer.xml");
	    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    	Document doc = dBuilder.parse(fXmlFile);
	     
	    	//optional, but recommended
	    	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	    	doc.getDocumentElement().normalize();
	     
	    	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	     
	    	NodeList nList = doc.getElementsByTagName("staff");
	     
	    	System.out.println("----------------------------");
	     
	    	for (int temp = 0; temp < nList.getLength(); temp++) {
	     
	    		Node nNode = nList.item(temp);
	     
	    		System.out.println("\nCurrent Element :" + nNode.getNodeName());
	     
	    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	     
	    			Element eElement = (Element) nNode;
	     
	    			System.out.println("Staff id : " + ((DocumentBuilderFactory) eElement).getAttribute("id"));
	    			System.out.println("First Name : " + ((Document) eElement).getElementsByTagName("firstname").item(0).getTextContent());
	    			System.out.println("Last Name : " + ((Document) eElement).getElementsByTagName("lastname").item(0).getTextContent());
	    			System.out.println("Nick Name : " + ((Document) eElement).getElementsByTagName("nickname").item(0).getTextContent());
	    			System.out.println("Salary : " + ((Document) eElement).getElementsByTagName("salary").item(0).getTextContent());
	     
	    		}
	    	}
	        } catch (Exception e) {
	    	e.printStackTrace();
	        }

	}

}
