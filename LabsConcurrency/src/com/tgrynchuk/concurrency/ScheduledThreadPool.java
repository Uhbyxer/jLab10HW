package com.tgrynchuk.concurrency;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
	public static final int TASK_COUNT = 10;
	
	public static void main(String[] args) {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(TASK_COUNT);
		
		System.out.println("Start...");
		for (int i = 0; i < TASK_COUNT; i++) {
			scheduledThreadPool.schedule(
					() -> {
						int s = new Random().nextInt(10);
						try {
							TimeUnit.SECONDS.sleep(s);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + "  Slept time = " + s);
					}, 
					new Random().nextInt(10), 
					TimeUnit.SECONDS  
					
					);
		}
		
		scheduledThreadPool.shutdown();
		while (!scheduledThreadPool.isTerminated()) {
		}
		System.out.println("Finished.");

	}

}
