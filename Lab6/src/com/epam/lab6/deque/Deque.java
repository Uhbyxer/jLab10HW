package com.epam.lab6.deque;

import java.util.Iterator;

public class Deque implements Iterable<Integer> {
	private int size;
	private Entry entry;
	
	private class Entry {
		
		private int value;
		private Entry head, tail;
		
		public Entry(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}
	
	public Deque() {
		entry = new Entry(0);
		entry.head = entry;
		entry.tail = entry;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public void addLast(int value) {
		size++;
		//ост
		Entry last = new Entry(value);
		//передост 
		Entry prevLast = entry.tail;
		
		//ссилка з ост на entry
		last.head = entry;
		//з ост на передост
		last.tail = prevLast;
		//з передост на ост
		prevLast.head = last;
		//з ентрі на ост
		entry.tail = last;
	}
	
	public void addFirst(int value) {
		size++;
		//перший
		Entry first = new Entry(value);
		//другий
		Entry nextFirst = entry.head;
		
		//ссилка з першого на ентрі
		first.tail = entry;
		//з першого на другий
		first.head = nextFirst;
		//з другого на перший
		nextFirst.tail = first;
		//з ентрі на перший
		entry.head = first;
		
	}	
	
	public Integer removeLast() {
		if(size == 0) return null;

		//ост
		Entry last = entry.tail;
		Entry prevLast = last.tail;
		
		//ссилка з передост на entry
		prevLast.head = entry;
		//з ентрі на передост
		entry.tail = prevLast;
		
		size--;
		return last.getValue();
	}
	
	public Integer removeFirst() {
		if(size == 0) return null;

		//перш
		Entry first = entry.head;
		Entry nextFirst = first.head;
		
		//ссилка з другого на entry
		nextFirst.tail = entry;
		//з ентрі на другий
		entry.head = nextFirst;
		
		size--;
		return first.getValue();
	}	
	
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			
			Entry current = entry;

			@Override
			public boolean hasNext() {
				return current.head != entry;
			}

			@Override
			public Integer next() {
				current = current.head;
				
				return current.getValue();
			}
			
		};
	}
}
