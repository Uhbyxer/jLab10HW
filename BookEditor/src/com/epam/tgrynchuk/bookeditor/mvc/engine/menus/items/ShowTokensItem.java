package com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.bookeditor.mvc.engine.BookController;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.bookeditor.mvc.models.Sentence;
import com.epam.tgrynchuk.bookeditor.mvc.models.Token;

public class ShowTokensItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(ShowTokensItem.class);
	
	private BookController controller;

	public ShowTokensItem(BookController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public boolean execute() {
		LOGGER.debug("ShowTokensItem.execute()");
		
		if(controller.getCurrentFile() == null) {
			controller.getWindow().showMessage(controller.getLocalMessage("For_first_open_file"));
			return true;
		}
		controller.getWindow().showMessage("\n" + controller.getLocalMessage("Text_of_file"));
		
		int i = 0;
		for(Sentence sent: controller.getText()) {
			
			for(Token token: sent) {
				controller.getWindow().showMessage(("<%Token% #" + (i++) + ">" + token.toString() +
						"</%Token%>").replaceAll("%Token%", token.getClass().getSimpleName()));
			}
			
		}
		
		return true;
	}

	@Override
	public String getKey() {
		return "6";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> " + controller.getLocalMessage("menu.show_tokens");	
	}
}
