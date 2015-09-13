package com.tgrynchuk.concurrency;

public class FibonacciRunable {
	public static final int N = 10;
	public static final int TASK_COUNT = 4;

	public static void main(String[] args) {
		
		for (int i = 0; i < TASK_COUNT; i++)
			
			new Thread(() -> {
				
				new Fibonacci(N).forEach(f -> System.out.println(Thread
						.currentThread().getName() + " : " + f));
			
			}).start();
		
	}

}
