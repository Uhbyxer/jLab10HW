package com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.bookeditor.mvc.engine.BookController;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.bookeditor.mvc.models.Token;

public class ShowSortedLambdaComparatorItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(ShowSortedLambdaComparatorItem.class);
	
	private BookController controller;

	public ShowSortedLambdaComparatorItem(BookController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public boolean execute() {
		LOGGER.debug("ShowSortedLambdaComparatorItem.execute()");
		
		if(controller.getCurrentFile() == null) {
			controller.getWindow().showMessage(controller.getLocalMessage("For_first_open_file"));
			return true;
		}
		controller.getWindow().showMessage("\n" + controller.getLocalMessage("Result"));
		
		for(Token token: controller.getText().getSortedWords(Token.BY_FIRST_CONSONANT_LAMBDA)) {
			controller.getWindow().showMessage(token.toString());
		}
		
		
		
		return true;
	}

	@Override
	public String getKey() {
		return "9";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> " + controller.getLocalMessage("menu.show_sorted_lambda_comparator");	
	}
}
