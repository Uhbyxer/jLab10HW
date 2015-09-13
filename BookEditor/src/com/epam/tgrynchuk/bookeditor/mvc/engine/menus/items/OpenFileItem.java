package com.epam.tgrynchuk.bookeditor.mvc.engine.menus.items;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.SetChangeListener;

import org.apache.log4j.Logger;








import com.epam.tgrynchuk.bookeditor.exceptions.OpenBookFileException;
import com.epam.tgrynchuk.bookeditor.mvc.engine.BookController;
import com.epam.tgrynchuk.bookeditor.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.bookeditor.mvc.models.Text;
import com.epam.tgrynchuk.bookeditor.mvc.ui.ScannerSigleton;
import com.epam.tgrynchuk.bookeditor.utils.TextFile;

public class OpenFileItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(OpenFileItem.class);
	
	private BookController controller;

	public OpenFileItem(BookController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public boolean execute() {
		LOGGER.debug("OpenFileItem.execute()");
		
		
		String path = "";
		File file = new File("./Files/");
		try {
			path = file.getCanonicalPath();


			List<File> files = new ArrayList<>();
			for (String f : file.list()) {
				files.add(new File(path + "\\" + f));
			}

			
			if(files.isEmpty()) {
				
				controller.getWindow().showMessage(controller.getLocalMessage("List_of_files_empty"));
				
			} else {
				
				controller.getWindow().showMessage(
						"\n" + controller.getLocalMessage("List_of_files"));
				files.forEach(x -> {
					controller.getWindow().showMessage(
							files.indexOf(x) + " --> "
									+ x.getAbsoluteFile().getName());
				});
				
				controller.getWindow().showMessage(controller.getLocalMessage("menu.enter_choise"));
				int key = ScannerSigleton.readPositiveInt(0, files.size() - 1);
				
				controller.setText(new Text(TextFile.readFromTextFile(files.get(key))));
				controller.getText().parse();
				controller.setCurrentFile(files.get(key));
				
				controller.getWindow().showMessage(
						"\n" + controller.getLocalMessage("File_is_opened"));
			}

			// for(File f: files) {
			// System.out.println(f.getName());
			// }
			
		} catch (Exception e) {
			controller.getWindow().showError(controller.getLocalMessage("Error_reading_file"));
			///throw new OpenBookFileException(e);
		}		
		
		return true;
	}

	@Override
	public String getKey() {
		return "1";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> " + controller.getLocalMessage("menu.open");	
	}
}
