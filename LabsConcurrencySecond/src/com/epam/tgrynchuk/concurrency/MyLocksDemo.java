package com.epam.tgrynchuk.concurrency;

import com.epam.tgrynchuk.concurrency.locks.MyConcurrentList;

public class MyLocksDemo {

	public static void main(String[] args) {
		
		MyConcurrentList<Integer> myList = new MyConcurrentList<Integer>();
		myList.add(0);
		
		new Thread( () -> { 
			for(int i = 1; i < 8; i++) 
				myList.get(0); 
		}, "Reader 1").start();	

		new Thread( () -> { 
			for(int i = 1; i < 8; i++) 
				myList.get(0); 
		}, "Reader 2").start();	
		
		new Thread( () -> { 
			for(int i = 1; i < 4; i++) 
				myList.add(i);
		}, "Writer 1").start();	
		
		new Thread( () -> { 
			for(int i = 1; i < 4; i++) 
				myList.add(i);
		}, "Writer 2").start();	
		
		new Thread( () -> { 
			for(int i = 1; i < 8; i++) 
				myList.get(0); 
		}, "Reader 3").start();			

	}

}
