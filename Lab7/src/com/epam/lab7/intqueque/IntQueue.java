package com.epam.lab7.intqueque;

import java.util.*;

import javafx.collections.transformation.SortedList;

public class IntQueue {
	private SortedMap<Integer, Integer> map = new TreeMap<>(BY_DESC_ORDER);
	
	
	
	public void push(Integer elem) {
		map.put(elem, elem);
	}
	
	public Integer pop() {
		if(map.isEmpty()) return null;
		Integer res = map.getOrDefault(map.firstKey(), null);
		
		if(res != null)
			map.remove(map.firstKey(), res);
		
		return  res;
		
	}
	
	public static final Comparator<Integer> BY_DESC_ORDER = new Comparator<Integer>() {
		
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};
}
