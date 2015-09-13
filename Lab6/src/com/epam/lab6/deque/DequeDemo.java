package com.epam.lab6.deque;

public class DequeDemo {

	public static void main(String[] args) {
		
		Deque deq = new Deque();
		
		System.out.println("===========================");
		System.out.println("addLast() --> 0..9");
		for(int i = 0; i < 10; i++) 
			deq.addLast(i);
		printDeque(deq);
		
		
		System.out.println("===========================");
		System.out.println("addFirst() --> 0..-9");
		for(int i = 0; i < 10; i++) 
			deq.addFirst(-i);
		printDeque(deq);		
		
		System.out.println("===========================");
		System.out.print("removeLast() --> ");
		for(int i = 0; i < 5; i++) 
			System.out.print(deq.removeLast() + "; ");
		printDeque(deq);
		
		System.out.println("===========================");
		System.out.print("removeFirst() --> ");
		for(int i = 0; i < 5; i++) 
			System.out.print(deq.removeFirst() + "; ");
		printDeque(deq);
		
		
		System.out.println("===========================");
		System.out.print("All: removeFirst() --> ");
		Integer d;
		while ((d = deq.removeFirst()) != null)
			System.out.print(d + "; ");
		System.out.println("\nsize(): " + deq.size());
		printDeque(deq);
		
	}
	
	public static void printDeque(Deque deq) {
		System.out.println("\nResult:");
		for(int d: deq) {
			System.out.println(d);
		}
	}

}
