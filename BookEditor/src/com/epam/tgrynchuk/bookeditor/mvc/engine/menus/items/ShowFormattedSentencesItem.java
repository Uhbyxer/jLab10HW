package com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.bookeditor.mvc.engine.BookController;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.MenuItem;

public class ShowFormattedSentencesItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(ShowFormattedSentencesItem.class);
	
	private BookController controller;

	public ShowFormattedSentencesItem(BookController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public boolean execute() {
		LOGGER.debug("ShowFormattedSentencesItem.execute()");
		
		if(controller.getCurrentFile() == null) {
			controller.getWindow().showMessage(controller.getLocalMessage("For_first_open_file"));
			return true;
		}
		controller.getWindow().showMessage("\n" + controller.getLocalMessage("Text_of_file"));
		
		for(int i = 0; i < controller.getText().size(); i++) {
			controller.getWindow().showMessage("--------------------------------------------------------------------------------------");
			controller.getWindow().showMessage("<Sentence #" + i + ">" + controller.getText().get(i).toString() +
					"</Sentence>");
		}
		
		
		
		return true;
	}

	@Override
	public String getKey() {
		return "5";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> " + controller.getLocalMessage("menu.show_formatted_sentences");	
	}
}
