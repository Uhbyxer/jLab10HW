package com.epam.tgrynchuk.xml.mvc.models;

import java.util.ArrayList;
import java.util.StringJoiner;

@SuppressWarnings("serial")
public class Candies extends ArrayList<Candy> {
	
	@Override
	public String toString() {
		
		StringJoiner result = 
				new StringJoiner("\n----------------------------------------------------------------------------\n");
		
		forEach(x -> result.add(x.toString()));
		
		return result.toString();
	}
	
}
