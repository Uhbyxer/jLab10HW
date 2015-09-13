package com.epam.tgrynchuk.xml.utils;

import java.io.File;
import java.io.FileInputStream;


import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import com.epam.tgrynchuk.xml.mvc.models.Candies;
import com.epam.tgrynchuk.xml.mvc.models.Candy;
import com.epam.tgrynchuk.xml.mvc.models.Ingredient;

public class SAXParser extends AbstractXMLParser {
	private Candies candyList;
	
	public SAXParser() {
	}	
	
	public SAXParser(File xsdPath) {
		super(xsdPath);
	}
	
	public SAXParser(String xsdPath) {
		super(xsdPath);
	}
	
	
	@Override
	protected boolean parse(Candies candyList) throws Exception {
		candyList.clear();
		this.candyList = candyList;
		
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		javax.xml.parsers.SAXParser parser = parserFactor.newSAXParser();
		SAXHandler handler = new SAXHandler();
		parser.parse(new FileInputStream(getXmlPath()), handler);
		
		return true;
	}
	
	
	private  class SAXHandler extends DefaultHandler {

		
		private Candy candy = null;
		private Ingredient ingredient = null;

		private String content = null;

		private SetterUtil<Candy> setterUtil = new SetterUtil<>(Candy.class);

		@Override
		// Triggered when the start of tag is found.
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {

			switch (qName.toLowerCase().trim()) {

			// Create a new object when the start tag is found
			case "candy":
				candy = new Candy(Integer.parseInt(attributes.getValue("id")));
				break;

			case "value":
				candy.setValue(
						Integer.parseInt(attributes.getValue("protein")),
						Integer.parseInt(attributes.getValue("fat")),
						Integer.parseInt(attributes.getValue("carbohydrates")));

				break;

			case "ingredient":
				ingredient = new Ingredient(attributes.getValue("name"));
				break;
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {

			switch (qName.toLowerCase().trim()) {

			case "candy":
				candyList.add(candy);

				break;

			case "ingredient":
				candy.put(ingredient, Integer.parseInt(content));

				break;

			}

			try {
				setterUtil.set(candy, qName.trim(), content);
			} catch (Exception e) {
				throw new SAXException(e);
			}

		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {

			content = String.copyValueOf(ch, start, length).trim();

		}

	}

}
