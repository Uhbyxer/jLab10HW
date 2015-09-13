package com.epam.tgrynchuk.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyArrayList<E> {
	private static final int WRITE_PAUSE = 2000;
	private static final int READ_PAUSE = 500;
	
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private final Lock readLock = readWriteLock.readLock();

	private final Lock writeLock = readWriteLock.writeLock();

	private final List<E> list = new ArrayList<>();

	public void add(E o) {
		String name = Thread.currentThread().getName();
		
		System.out.println(name + " add " + o + " start...");
		
		writeLock.lock();
		
		System.out.println(name + " add " + o + " write lock");
		
		try {
			
			TimeUnit.MILLISECONDS.sleep(WRITE_PAUSE);
			list.add(o);
			
			System.out.println(name + " add " + o + " done");			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			writeLock.unlock();
		}
		
		System.out.println(name + " add " + o + " end...");
		
	}

	public E get(int i) {
		E res = null;
		String name = Thread.currentThread().getName();
		
		System.out.println(name + " get " + i + " start...");
		readLock.lock();
		System.out.println(name + " get " + i + " read lock");
		try {
			res = list.get(i);
			
			TimeUnit.MILLISECONDS.sleep(READ_PAUSE);
			
			System.out.println(name + " get " + i + " done");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			readLock.unlock();
		}
		return res;
	}

	public static void main(String[] args) {
		MyArrayList<Integer> myList = new MyArrayList<>();
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
		
//		myList.add(1);
//		myList.add(2);
//
//		myList.get(0);
		
	}
}
