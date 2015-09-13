package com.tgrynchuk.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {
	public static final int N = 20;
	public static final int TASK_COUNT = 4;
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		for (int i = 0; i < TASK_COUNT; i++)
		executorService.execute(
				() -> {
					
					new Fibonacci(N).forEach(f -> System.out.println(Thread
							.currentThread().getName() + " : " + f));
				
				}
		);

		executorService.shutdown();

	}

}
