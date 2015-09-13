package com.epam.tgrynchuk.bookeditor.mvc.models;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.epam.tgrynchuk.bookeditor.utils.TextFile;

public class SentenceTest {
	
	private static Sentence sent;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String name; 
		name = ".\\Files\\Effective java.txt";
		name = ".\\Files\\Sun.txt";
		name =  ".\\Files\\Weisfeld.txt";
		name =  ".\\Files\\Eckel.txt";
		
		Text text = new Text(TextFile.readFromTextFile(new File(name)));
		text.parse();
		
		sent = text.get(7);
		
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Ignore
	@Test
	public void test() {
		sent.parse();
		for(Token t: sent) {
			if(t.isWord()) System.out.println(t);
			else {
				System.out.println("[" + t + "]");
			}
		}
		
	}
	
	@Ignore
	@Test
	public void testWords() {
		sent.parse();
		for(Token t: sent) {
			
			if(t.isWord()) System.out.println(t);
		}
	}
	
	
	@Ignore
	@Test
	public void testWithTrim() {
		sent.parse();
		for(Token t: sent) {
			if(t.isWord()) System.out.println(t.getOldValue());
			else {
				System.out.println("[" + t.getOldValue() + "]");
			}
		}
		
		
		System.out.println("=======================================================================");
		//sent.trimPunctuation();
		
		for(Token t: sent) {
			if(t.isWord()) System.out.println(t.getOldValue());
			else {
				System.out.println("[" + t.getOldValue() + "]");
			}
		}
	}
	
	@Ignore
	@Test
	public void testToString() {
		sent.parse();
		for(Token t: sent) {
			if(t.isWord()) System.out.println(t.getOldValue());
			else {
				System.out.println("[" + t.getOldValue() + "]");
			}
		}
		
		
		System.out.println("=======================================================================");
		System.out.println(sent);
		System.out.println("=======================================================================");
	}
	
	@Test
	public void testToNull() {
		sent.parse();
		for(Token t: sent) {
			if(t == null || "".equals(t)) {
				System.out.println(t);
				fail();
			}
		}
		
		
	}

}
