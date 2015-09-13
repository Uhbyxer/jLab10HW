package com.epam.tgrynchuk.xml.mvc.engine;

import java.awt.Desktop;
import java.io.File;
import java.util.Collections;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import static com.epam.tgrynchuk.xml.Constants.*;

import com.epam.tgrynchuk.xml.mvc.dao.CandiesDAO;
import com.epam.tgrynchuk.xml.mvc.dto.CandiesDTO;
import com.epam.tgrynchuk.xml.mvc.dto.IngredientDTO;
import com.epam.tgrynchuk.xml.mvc.dto.IngredientsDTO;
import com.epam.tgrynchuk.xml.mvc.gui.MainWindow;
import com.epam.tgrynchuk.xml.mvc.models.Candies;
import com.epam.tgrynchuk.xml.mvc.models.Candy;
import com.epam.tgrynchuk.xml.mvc.models.Ingredient;
import com.epam.tgrynchuk.xml.utils.AbstractXMLParser;
import com.epam.tgrynchuk.xml.utils.XSLTransformer;


public class XmlController {
	private File currentFile;
	
	private MainWindow window;
	
	private Candies candies = null;

	public XmlController() {
		currentFile = new File(INITAL_XML_PATH);
	}

	public File getCurrentFile() {
		return currentFile;
	}

	public void setCurrentFile(File currentFile) {
		this.currentFile = currentFile;
	}

	public void checkXSD() {
		if (AbstractXMLParser.isValid(currentFile, new File(INITAL_XSD_PATH))) {
			window.println("File is valid to Scheme: " + INITAL_XSD);
		} else {
			window.showErrorMessage("File is not valid to Scheme: " + INITAL_XSD, "Not valid !!!");
		}
	}

	public void parseXML(String parserName) {
		
		candies =  CandiesDAO.getAllCandies(parserName, currentFile, new File(INITAL_XSD_PATH));
		
		if(candies == null) {
			window.showErrorMessage("Error parsing from file: " + currentFile.getName(), "Error !!!");
			return;
		}
		
		window.clear();
		window.println("=================================================================");
		window.println("Candies by " + parserName + ":\n");
		window.println(candies);
		window.println("");
		
		//Collections.sort(candies, Candy.BY_NAME);
	}

	public void convertToXML() {
		if(candies == null) {
			window.showErrorMessage("Nothing to convert ! ", "Error !!!");
			return;
		}
		
		File file = new File(INITAL_DIRECTORY + "ingredients.xml");
		
		IngredientsDTO ingrediens = IngredientsDTO.getAllIngredients(candies, file);
		
		
        if(ingrediens == null) {
			window.showErrorMessage("Error converting  to file: ingredients.xml", "Error !!!");
			return;
        }
        
        window.println("Converting to file: " + file.getName() + " done !");
        openFileInBrowser(file);
	}

	public void convertToHTML() {
		if(candies == null) {
			window.showErrorMessage("Nothing to convert ! ", "Error !!!");
			return;
		}
		
		File file = new File(INITAL_DIRECTORY + "ingredients.xml");
		
		IngredientsDTO ingrediens = IngredientsDTO.getAllIngredients(candies, file);
		
        if(ingrediens == null) {
			window.showErrorMessage("Error converting  to file: ingredients.xml", "Error !!!");
			return;
        }
        
        //ingrediens.sort();
        
        //System.out.println(ingrediens);
        
        String html = XSLTransformer.getHtmlFromXml(INITAL_DIRECTORY, file, new File(INITAL_DIRECTORY + "ingredients.xsl"));
        
        if(html == null) {
			window.showErrorMessage("Error converting ingredients.xml to HTML !", "Error !!!");
			return;
        }
        
        window.println("Converting to html: " + html + " done !");
        openFileInBrowser(new File(html));
        
	}
	
	public void showInitalFile() {
		openFileInBrowser(currentFile);
	}
	
	public void openFileInBrowser(File file) {
        Desktop dt = Desktop.getDesktop();
        try {
            dt.open(file);
        } catch(Exception e) {
        	window.showErrorMessage("Error opening file in browser ! ", file.getName());
        } 
	}

	public void start() {
		window = new MainWindow(this);
	}

}
