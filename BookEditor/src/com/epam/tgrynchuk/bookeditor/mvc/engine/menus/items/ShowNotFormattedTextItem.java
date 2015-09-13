package com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.bookeditor.mvc.engine.BookController;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.bookeditor.mvc.models.Text;
import com.epam.tgrynchuk.bookeditor.mvc.ui.ScannerSigleton;
import com.epam.tgrynchuk.bookeditor.utils.TextFile;

public class ShowNotFormattedTextItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(ShowNotFormattedTextItem.class);
	
	private BookController controller;

	public ShowNotFormattedTextItem(BookController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public boolean execute() {
		LOGGER.debug("ShowNotFormattedTextItem.execute()");
		
		if(controller.getCurrentFile() == null) {
			controller.getWindow().showMessage(controller.getLocalMessage("For_first_open_file"));
			return true;
		}
		controller.getWindow().showMessage("\n" + controller.getLocalMessage("Text_of_file"));
		controller.getWindow().showMessage(controller.getText().getOldValue());
		
		
		return true;
	}

	@Override
	public String getKey() {
		return "2";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> " + controller.getLocalMessage("menu.show_not_formatted");	
	}
}
