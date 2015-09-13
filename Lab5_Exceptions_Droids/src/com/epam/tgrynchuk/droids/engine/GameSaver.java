package com.epam.tgrynchuk.droids.engine;

import java.io.IOException;

import com.epam.tgrynchuk.droids.exceptions.DroidException;

public class GameSaver implements AutoCloseable {
	private String fileName;
	private String[] params;

	public GameSaver(String fileName, String[] params) {
		super();
		this.fileName = fileName;
		this.params = params;
	}
	
	public void save() {
		System.out.println("Trying to save...");
		
		try {
			
			String secondParam = params[1];
			System.out.println(secondParam);
			
		} catch(ArrayIndexOutOfBoundsException e) {
			throw new DroidException("Wrong aray of params", e);

		}
		
	}

	@Override
	public void close() throws DroidException {
		//int a = 1/0;
		System.out.println("File closed!");
		
	}
	
}
