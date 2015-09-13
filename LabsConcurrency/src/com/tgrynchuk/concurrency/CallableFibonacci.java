package com.tgrynchuk.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;



public class CallableFibonacci {
	public static final int N = 20;
	public static final int TASK_COUNT = 5;
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		
		ExecutorService executor = Executors.newFixedThreadPool(TASK_COUNT);
		List<Future<String>> list = new ArrayList<>();
		
		for (int i = 0; i < TASK_COUNT; i++) {
			Future<String> future = executor.submit(

			() -> {
				long result = 0L;

				for (int f : new Fibonacci(N))
					result += f;

				return Thread.currentThread().getName() + ":" + result;

			}

			);
			list.add(future);
		}			

		for (Future<String> fut : list) {
			try {
				System.out.println(fut.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		

		
		executor.shutdown();	
		
	}

}
