package com.epam.tgrynchuk.bookeditor.mvc.engine;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.Menu;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items.ChangeLangItem;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items.OpenFileItem;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items.QuitProgtramItem;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items.ShowFormattedSentencesItem;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items.ShowFormattedTextItem;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items.ShowNotFormattedSentencesItem;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items.ShowNotFormattedTextItem;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items.ShowSortedItem;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items.ShowSortedLambdaComparatorItem;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items.ShowTokensItem;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items.ShowWordsItem;
import com.epam.tgrynchuk.bookeditor.mvc.models.*;
import com.epam.tgrynchuk.bookeditor.mvc.ui.ScannerSigleton;
import com.epam.tgrynchuk.bookeditor.mvc.ui.Window;
import com.epam.tgrynchuk.bookeditor.utils.Alphabet;


public class BookController {
	private static final Logger LOGGER = Logger.getLogger(BookController.class);
	private final Window window;
	private File currentFile = null;
	private Text text = null;
	
	private ResourceBundle resBundle;
	
	
	public BookController() {
		LOGGER.trace("BookController()-->");
		window = new Window();
	}
	
	public String getLocalMessage(String key) {
		try {
			return resBundle.getString(key);
		} catch(Exception e) {
			return key;
		}
	}
	
	private boolean isLangUA;
	
	public void setLangUA() {
		resBundle = ResourceBundle.getBundle("local/message", new Locale("ua", "ua"));
		ScannerSigleton.setResourceBundle(resBundle);
		
		isLangUA = true;
		LOGGER.info("set lang ua");
	}
	
	public void setLangEN() {
		resBundle = ResourceBundle.getBundle("local/message", new Locale("en", "us"));
		ScannerSigleton.setResourceBundle(resBundle);
		
		isLangUA = false;
		LOGGER.info("set lang en");
	}	
	
	public void changeLang() {
		if(isLangUA) setLangEN();
		else setLangUA();
	}
	
	
	public Window getWindow() {
		return window;
	}
	
	
	public File getCurrentFile() {
		return currentFile;
	}

	public void setCurrentFile(File currentFile) {
		this.currentFile = currentFile;
	}
	
	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public void start() {
		LOGGER.info("start()-->");
		setLangEN();
		
		Menu mainMenu = new Menu(
				new ChangeLangItem(this),
				new OpenFileItem(this),
				new ShowNotFormattedTextItem(this),
				new ShowFormattedTextItem(this),
				new ShowNotFormattedSentencesItem(this),
				new ShowFormattedSentencesItem(this),
				new ShowTokensItem(this),
				new ShowWordsItem(this),
				new ShowSortedItem(this),
				new ShowSortedLambdaComparatorItem(this),
				new QuitProgtramItem(this)
				
		);
		
		for(;;) {
			String key = window.showMenu(mainMenu.getItems(), getLocalMessage("menu.title"), getLocalMessage("menu.enter_choise"));
			
			LOGGER.debug("mainMenu.select " + key);
			
			mainMenu.select(key);
		}
		
	}
	

}
