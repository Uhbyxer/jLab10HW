package com.epam.lab9;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab9.annot.DroidExecutor;


public class DroidBrowser {
	private ArrayList<Droid> holder;

	@DroidExecutor(sqlStatement = "mkmkmk", clazz = DroidExecutor.class)
	public List<Droid> getDroids() {
		return holder;
	}
	
	@DroidExecutor(sqlStatement = "update Droids", transactionRequired = true, notifyOnUpdates = true)
	public void updateData() {
		System.out.println("Updating to DB...");
	}
	
	@DroidExecutor(sqlStatement = "")
	public void doSomething(String str, Integer i) {
		
	}
	
	public DroidBrowser() {
		holder = new ArrayList<Droid>();
		
	}

	public DroidBrowser(Droid ...droids) {
		holder = new ArrayList<Droid>();
		for(Droid d: droids) holder.add(d);
	}

}
