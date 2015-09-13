package com.epam.lab7.droidqueue;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class DroidQueue<T> {
	private SortedMap<T, T> map;
	
	public DroidQueue(Comparator<? super T> comparator) {
		map = new TreeMap<>(comparator);
	}
	
	public void push(T elem) {
		map.put(elem, elem);
	}
	
	public T pop() {
		if(map.isEmpty()) return null;
		T res = map.getOrDefault(map.firstKey(), null);
		
		if(res != null)
			map.remove(map.firstKey(), res);
		
		return  res;
		
	}
}
