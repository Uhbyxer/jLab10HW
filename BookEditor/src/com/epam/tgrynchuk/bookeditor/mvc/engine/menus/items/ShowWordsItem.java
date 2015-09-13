package com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.bookeditor.mvc.engine.BookController;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.bookeditor.mvc.models.Sentence;
import com.epam.tgrynchuk.bookeditor.mvc.models.Token;

public class ShowWordsItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(ShowWordsItem.class);
	
	private BookController controller;

	public ShowWordsItem(BookController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public boolean execute() {
		LOGGER.debug("ShowWordsItem.execute()");
		
		if(controller.getCurrentFile() == null) {
			controller.getWindow().showMessage(controller.getLocalMessage("For_first_open_file"));
			return true;
		}
		controller.getWindow().showMessage("\n" + controller.getLocalMessage("Text_of_file"));
		
		for(Sentence sent: controller.getText()) {
			
			for(Token token: sent) {
				if(token.isWord())
					controller.getWindow().showMessage(token.toString());
			}
			
		}
		
		return true;
	}

	@Override
	public String getKey() {
		return "7";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> " + controller.getLocalMessage("menu.show_words");	
	}
}
