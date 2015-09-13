package com.tgrynchuk.concurrency;

import java.util.Iterator;



public class Fibonacci implements Iterable<Integer> {
	private final int n;
	
	public int getN() {
		return n;
	}
	
	public Fibonacci(int n) {
		this.n = n;
	}

	@Override
	public Iterator<Integer> iterator() {
		
		return new Iterator<Integer>() {
			
			private int first = 0, second = 1, i = 0;
			

			@Override
			public boolean hasNext() {
				
				return i++ < n;
			}

			@Override
			public Integer next() {
				
				int result = first;
				
				int third = first + second;
				
				first = second;
				
				second = third;
				
				return result;
			}
			
		};
	}

}