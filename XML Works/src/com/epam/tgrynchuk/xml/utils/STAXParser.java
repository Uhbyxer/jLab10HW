package com.epam.tgrynchuk.xml.utils;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.epam.tgrynchuk.xml.mvc.models.Candies;
import com.epam.tgrynchuk.xml.mvc.models.Candy;
import com.epam.tgrynchuk.xml.mvc.models.Ingredient;

public class STAXParser extends AbstractXMLParser {

	public STAXParser() {
	}	
	
	public STAXParser(File xsdPath) {
		super(xsdPath);
	}
	
	public STAXParser(String xsdPath) {
		super(xsdPath);
	}
	
	@Override
	protected boolean parse(Candies candyList) throws Exception {
		
		candyList.clear();
		Candy currentCandy = null;
		Ingredient ingredient = null;
		String tagContent = null;
		SetterUtil<Candy> setterUtil = new SetterUtil<>(Candy.class);


		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(
				new FileInputStream(getXmlPath()));

		while (reader.hasNext()) {
			int event = reader.next();
			
			switch (event) {

			case XMLStreamConstants.START_ELEMENT:

				if ("candy".equals(reader.getLocalName().toLowerCase())) {

					currentCandy = new Candy(Integer.parseInt(reader.getAttributeValue(0)));
				
				} else if ("ingredient".equals(reader.getLocalName().toLowerCase())) {	
					
					ingredient = new Ingredient(reader.getAttributeValue(0));
					
				} else if ("candies".equals(reader.getLocalName().toLowerCase())) {

					candyList.clear();

				} else if ("value".equals(reader.getLocalName().toLowerCase())) {
					
					currentCandy.setValue(
							Integer.parseInt(reader.getAttributeValue(0)), 
							Integer.parseInt(reader.getAttributeValue(1)), 
							Integer.parseInt(reader.getAttributeValue(2))
					);
				}
				
				break;

			case XMLStreamConstants.CHARACTERS:

				tagContent = reader.getText().trim();

				break;

			case XMLStreamConstants.END_ELEMENT:

				switch (reader.getLocalName().toLowerCase()) {

				case "candy":

					candyList.add(currentCandy);

					break;

				case "ingredient":

					currentCandy.put(ingredient, Integer.parseInt(tagContent));
					break;
				}
				
				try {
					setterUtil.set(currentCandy, reader.getLocalName(), tagContent);
				} catch (Exception e) {
					throw new XMLStreamException(e);
				}				

				break;

			case XMLStreamConstants.START_DOCUMENT:

				candyList.clear();

				break;

			}

		}
		
		
		return true;
	}

}
