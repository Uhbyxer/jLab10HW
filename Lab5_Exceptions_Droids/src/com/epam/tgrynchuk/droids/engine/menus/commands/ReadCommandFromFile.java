package com.epam.tgrynchuk.droids.engine.menus.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.epam.tgrynchuk.droids.engine.menus.Command;
import com.epam.tgrynchuk.droids.exceptions.DroidException;

public class ReadCommandFromFile implements Command{

	@Override
	public void execute() {
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("ArmyList.txt")));
			String s = "";
			try{
				while((s = in.readLine()) != null) {
					String[] a = s.split("\t");
					
					int n = Integer.parseInt(a[0]);
				}
			} catch(NumberFormatException|ArrayIndexOutOfBoundsException e) {
				throw new DroidException("Wrong line format", e);
			} finally{
				in.close();
			}
		} catch(IOException e){
			throw new DroidException("Wrong file name", e);
		}
		
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "r";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Read army from file";
	}
	 
	
}
