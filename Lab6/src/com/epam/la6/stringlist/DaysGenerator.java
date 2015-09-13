package com.epam.la6.stringlist;

import java.util.Iterator;

public class DaysGenerator implements Iterable<String> {
	private static final String[] 
			DAYS = "Sunday Monday Tuesday Wednesday Thursday Friday Saturday".split(" "); 
	
	private int size;
	
	public DaysGenerator(int size) {
		this.size = size;
	}

	@Override
	public Iterator<String> iterator() {
		
		return new Iterator<String>() {
			int index = -1, count = 0;
			
			@Override
			public boolean hasNext() {
				return count < size;
			}

			@Override
			public String next() {
				count++;
				if(++index  == DAYS.length) index = 0;
				return DAYS[index];
			}
			
		};
	}

}
