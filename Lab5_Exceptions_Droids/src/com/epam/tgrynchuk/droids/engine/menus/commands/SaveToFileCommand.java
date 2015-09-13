package com.epam.tgrynchuk.droids.engine.menus.commands;

import com.epam.tgrynchuk.droids.engine.GameSaver;
import com.epam.tgrynchuk.droids.engine.menus.Command;



public class SaveToFileCommand implements Command {
	private String fileName;
	private String[] params;
	
	@Override
	public void execute() {
		
		
		try(GameSaver gs = new GameSaver(fileName, params)) {
			gs.save();
		}
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "s";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Save army to file";
	}
	
	
	
	public SaveToFileCommand(String fileName, String[] params) {
		super();
		this.fileName = fileName;
		this.params = params;
	}

}
