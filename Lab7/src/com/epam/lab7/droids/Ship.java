package com.epam.lab7.droids;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ship<T extends Droid> implements Iterable<T> {
	private List<T> list;

	public Ship(T ... type) {
		list = new ArrayList<T>();
		for(T t: type) {
			list.add(t);
			put(t);
		}
	}
	
	public T get(int index) {
		T res = list.get(index);
		System.out.println("Get " + res + " from the ship");
		list.remove(index);
		return res;
	}
	
	public void put(T t) {
		System.out.println("Put " + t + " into the ship");
		list.add(t);
	}
	
	public int size() {
		return list.size();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Iterator<T> iter = list.iterator();

			@Override
			public boolean hasNext() {
				return iter.hasNext();
			}

			@Override
			public T next() {
				return iter.next();
			}
			
		};
	}
}
