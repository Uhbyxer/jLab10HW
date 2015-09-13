package com.epam.tgrynchuk.xml.utils;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.epam.tgrynchuk.xml.mvc.models.Candies;
import com.epam.tgrynchuk.xml.mvc.models.Candy;

public class DOMParser extends AbstractXMLParser {
	
	public DOMParser() {
	}	
	
	public DOMParser(File xsdPath) {
		super(xsdPath);
	}
	
	public DOMParser(String xsdPath) {
		super(xsdPath);
	}

	@Override
	protected boolean parse(Candies candyList) throws Exception {
		
		// Get the DOM Builder Factory
		DocumentBuilderFactory factory =

		DocumentBuilderFactory.newInstance();

		// Get the DOM Builder
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Load and Parse the XML document
		// document contains the complete XML as a Tree.

		Document document = builder.parse(new FileInputStream(getXmlPath()));

		//candyList = new Candies();
		candyList.clear();

		SetterUtil<Candy> setterUtil = new SetterUtil<>(Candy.class);

		// Iterating through the nodes and extracting the data.
		NodeList nodeList = document.getDocumentElement().getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);

			if (node instanceof Element) {

				Candy candy = new Candy(Integer.parseInt(node.getAttributes()
						.getNamedItem("id").getNodeValue()));

				NodeList childNodes = node.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {

					Node cNode = childNodes.item(j);

					// Identifying the child tag of employee encountered.
					if (cNode instanceof Element) {

						if ("value".equals(cNode.getNodeName().toLowerCase())) {

							candy.setValue(Integer.parseInt(cNode
									.getAttributes().getNamedItem("protein")
									.getNodeValue()), Integer.parseInt(cNode
									.getAttributes().getNamedItem("fat")
									.getNodeValue()), Integer.parseInt(cNode
									.getAttributes()
									.getNamedItem("carbohydrates")
									.getNodeValue()));

						} else if ("ingredients".equals(cNode.getNodeName()
								.toLowerCase())) {
							NodeList ingedientsNodes = cNode.getChildNodes();

							for (int k = 0; k < ingedientsNodes.getLength(); k++) {
								Node ingedient = ingedientsNodes.item(k);
								if (ingedient instanceof Element) {
									candy.put(
											ingedient.getAttributes()
													.getNamedItem("name")
													.getNodeValue(),
											Integer.parseInt(ingedient
													.getLastChild()
													.getTextContent().trim()));
								}
							}
						} else {

							String content = cNode.getLastChild()
									.getTextContent().trim();

							setterUtil.set(candy, cNode.getNodeName(), content);

						}

					}

				}

				candyList.add(candy);
			}

		}
		
		return true;
	}
}
