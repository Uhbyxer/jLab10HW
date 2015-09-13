package com.epam.tgrynchuk.bookeditor;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.bookeditor.mvc.engine.BookController;

public class EntryPoint {
	private static final Logger LOGGER = Logger.getLogger(EntryPoint.class);

	public static void main(String[] args) {
		LOGGER.info("Starts......");
		BookController controller = new BookController();
		controller.start();
		
		System.out.println("Entry");
		
	}

}
