package com.epam.tgrynchuk.lab5;

import java.util.Iterator;

//перевизначимо Iterable для роботи з циклом foreach
public class OddEven implements Iterable<Integer> {
	private final int from, to;

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}
	
	public OddEven(int from, int to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			
			private int nextInt = from % 2 == 0 ? from + 1 : from;

			@Override
			public boolean hasNext() {
				return nextInt <= to;
			}

			@Override
			public Integer next() {
				int result = nextInt;
				nextInt += 2;
				return result;
			}
			
		};
	}

	
	public Iterable<Integer> getEvenFromEndToStart() {
		return new Iterable<Integer>() {

			@Override
			public Iterator<Integer> iterator() {
				
				return new Iterator<Integer>() {
					private int prevInt = to % 2 == 0 ? to : to - 1;

					@Override
					public boolean hasNext() {
						return prevInt >= from;
					}

					@Override
					public Integer next() {
						int result = prevInt;
						prevInt -= 2;
						return result;
					}
					
				};
			}
			
		};
	}
}
