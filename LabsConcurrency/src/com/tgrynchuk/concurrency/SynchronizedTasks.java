package com.tgrynchuk.concurrency;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedTasks {
	private final static int MAX_TIME_TO_SLEEP = 800;
	
	private final static int MAX = 20;
	
	private volatile int count = 0;
	
	private volatile AtomicInteger x = new AtomicInteger(0);
	
	private Object first, second, third;
	
	
	public SynchronizedTasks(Object first, Object second, Object third) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
	}

	public int getCount() {
		return count;
	}

	public void inc() {
		synchronized (first) {
			count++;

			x.incrementAndGet();

			try {
				TimeUnit.MILLISECONDS.sleep(new Random().nextInt(MAX_TIME_TO_SLEEP));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("x++ : " + x);
		}
	}
	
	public synchronized void dec() {
		synchronized (second) {
			count++;

			x.decrementAndGet();

			try {
				TimeUnit.MILLISECONDS.sleep(new Random().nextInt(MAX_TIME_TO_SLEEP));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("x-- : " + x);
		}
	}
	
	public synchronized void init() {
		synchronized (third) {
			count++;

			x.set(0);;

			try {
				TimeUnit.MILLISECONDS.sleep(new Random().nextInt(MAX_TIME_TO_SLEEP));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("x=0 : " + x);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Object obj = new Object();
		
		//SynchronizedTasks task = new SynchronizedTasks(obj, obj, obj);
		SynchronizedTasks task = new SynchronizedTasks(new Object(), new Object(), new Object());
		
		new Thread(
			    () -> {
					while (task.getCount() < MAX) task.inc();
			    }
			).start();		
		
		
		new Thread(
			    () -> {
					while (task.getCount() < MAX) task.dec();
			    }
			).start();	
		
		
		new Thread(
			    () -> {
					while (task.getCount() < MAX) task.init();
			    }
			).start();		


	}

	
}
