package com.epam.tgrynchuk.xml.utils;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTransformer {
	public static String getHtmlFromXml(String directory, File xml, File xsl) {
		String outputFileName = null;
		
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();

            Source xslDoc = new StreamSource(xsl);
            Source xmlDoc = new StreamSource(xml);

            outputFileName = directory + "ingredients.html";
            FileOutputStream htmlFile = new FileOutputStream(outputFileName);
            

            Transformer transformer = tFactory.newTransformer(xslDoc);
            transformer.transform(xmlDoc, new StreamResult(htmlFile));
        }
        catch(Exception e) {
        	return null;
        }		
		return outputFileName;
	}
}
