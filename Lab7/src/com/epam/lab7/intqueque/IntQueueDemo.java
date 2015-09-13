package com.epam.lab7.intqueque;

import java.util.Random;

public class IntQueueDemo {

	public static void main(String[] args) {
		
		IntQueue q = new IntQueue();
		
		for(int i = 0; i < 6; i++) {
			Integer n = new Random().nextInt(50);
			System.out.println(n);
			q.push(n);
			
		}
		System.out.println("==========================");
		//System.out.println(q.pop());
		//System.out.println(q.pop());
		
		Integer p;
		while((p = q.pop()) != null) {
			System.out.println(p);
		}

	}

}
