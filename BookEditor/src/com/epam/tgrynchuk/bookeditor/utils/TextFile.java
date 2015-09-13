package com.epam.tgrynchuk.bookeditor.utils;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringJoiner;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.bookeditor.exceptions.OpenBookFileException;





public class TextFile {
	private static final Logger LOGGER = Logger.getLogger(TextFile.class);
	
	public static String readFromTextFile(File file) {
		LOGGER.trace("readFromTextFile-->");
		
		StringJoiner joiner = new StringJoiner("\n");
		
		try (BufferedReader in = new BufferedReader(new FileReader(file))) {
			String s = "";
			
			while((s = in.readLine()) != null) {
				joiner.add(s);
			}
			
			
			return joiner.toString();
			
		} catch(IOException e) {
			throw new OpenBookFileException(e);
		}		
		
	}
}
