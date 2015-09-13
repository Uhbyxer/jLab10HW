package com.epam.tgrynchuk.concurrency;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedTasks {
	private final static int MAX_TIME_TO_SLEEP = 800;
	
	private final static int MAX = 20;
	
	private volatile int count = 0;
	
	private volatile AtomicInteger x = new AtomicInteger(0);
	
	private Lock first, second, third;
	
	
	public SynchronizedTasks(Lock first, Lock second, Lock third) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
	}

	public int getCount() {
		return count;
	}

	public void inc() {
		first.lock();
		
		count++;

		x.incrementAndGet();

		try {
			TimeUnit.MILLISECONDS
					.sleep(new Random().nextInt(MAX_TIME_TO_SLEEP));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("x++ : " + x);
		
		first.unlock();
	}
	
	public synchronized void dec() {
		second.lock();
		
		count++;

		x.decrementAndGet();

		try {
			TimeUnit.MILLISECONDS
					.sleep(new Random().nextInt(MAX_TIME_TO_SLEEP));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("x-- : " + x);
		
		second.unlock();
	}
	
	public synchronized void init() {
		third.lock();

		count++;

		x.set(0);
		;

		try {
			TimeUnit.MILLISECONDS
					.sleep(new Random().nextInt(MAX_TIME_TO_SLEEP));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("x=0 : " + x);

		third.unlock();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Lock lock = new ReentrantLock();
		
		SynchronizedTasks task = new SynchronizedTasks(lock, lock, lock);
		//SynchronizedTasks task = new SynchronizedTasks(new ReentrantLock(), new ReentrantLock(), new ReentrantLock());
		
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
