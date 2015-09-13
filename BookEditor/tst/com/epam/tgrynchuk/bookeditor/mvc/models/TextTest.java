package com.epam.tgrynchuk.bookeditor.mvc.models;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.epam.tgrynchuk.bookeditor.utils.TextFile;

public class TextTest {
	private static Text text;
	
	
	@BeforeClass
	public static void before() {
		String name; 
		name =  ".\\Files\\Empty.txt";
		name = ".\\Files\\Effective java.txt";
		name = ".\\Files\\Sun.txt";
		name =  ".\\Files\\Weisfeld.txt";
		//name =  ".\\Files\\Eckel.txt";
		
		
		text = new Text(TextFile.readFromTextFile(new File(name)));
	}

	@Ignore
	@Test
	public void testParse() {
		
		text.parse();
		for (Sentence sen: text) {
			System.out.println(sen.getOldValue());
			System.out.println("=================================================");
		}
		
		//assertTrue(true);
	}
	
	@Ignore
	@Test
	public void testParseFinal() {
		
		text.parse();
		
		System.out.println("===========================================================");
		System.out.println(text);
		System.out.println("===========================================================");
		System.out.println("before");
		System.out.println("------------------------------------------------------------");
		System.out.println(text.getOldValue());
		System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testSort() {
		
		text.parse();
		
		
		Set<Token> set = text.getSortedWords();
		System.out.println(set);


		
	}	
	
}
