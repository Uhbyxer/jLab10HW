package com.epam.lab10;

import java.io.File;
import java.io.IOException;

public class Greetings {
	public String sayHello() {
		return "Hello";
	}
	
	private String getPassword(int v) {
		return ((Integer)v).toString();
	}
	
	public void newFile(String fileName) throws IOException {
		new File(fileName).createNewFile();
	}
}
