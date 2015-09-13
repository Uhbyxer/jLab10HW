package com.epam.tgrynchuk.jewelry.mvc.models;

import java.util.*;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.models.enums.StoneTransparency;

public class ListOfStones extends ArrayList<Stone> implements Valuable {
	private static final Logger LOGGER = Logger.getLogger(ListOfStones.class);
	private static final long serialVersionUID = 1L;
	
	{
		LOGGER.trace("ListOfStones {}");
	}
	
	

	
	public ArrayList<Stone> getByRangeOfTransparency(StoneTransparency from, StoneTransparency to) {
		ArrayList<Stone> res = new ArrayList<>();
		
        stream().filter((s) -> (s.getTransparency().getIndex() >= from.getIndex() 
        		                           && s.getTransparency().getIndex() <= to.getIndex())).
        		                           forEach((s) -> {
        		                        	   res.add(s);
        });
        
		return res;
	}
	
	public ArrayList<Stone> getByRangeOfTransparency(int from, int to) {
		ArrayList<Stone> res = new ArrayList<>();
		
        stream().filter((s) -> (s.getTransparency().getIndex() >= from 
        		                           && s.getTransparency().getIndex() <= to)).
        		                           forEach((s) -> {
        		                        	   res.add(s);
        });
        
		return res;
	}	
	@Override
	public double getValue() {
		double res = 0;
		for (Stone s : this)
			res += s.getValue();
		return res;
	}

	@Override
	public double getWeight() {
		double res = 0;
		for (Stone s : this)
			res += s.getWeight();
		return res;
	}
	

	
	public int getNewId() {
		int res = -1;

		for (Stone s : this)
			if (s.getId() > res)
				res = s.getId();

		return res + 1;
	}
	
	public Stone getStoneById(int id) {
		Stone res = null;
		
		for(Stone s: this)
			if(s.getId() == id) {
				res = s;
				break;
			}
		
		return res;
	}
}
