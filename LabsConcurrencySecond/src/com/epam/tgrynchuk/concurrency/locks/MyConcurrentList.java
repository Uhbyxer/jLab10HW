package com.epam.tgrynchuk.concurrency.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyConcurrentList<E> {
	private static final int WRITE_PAUSE = 2000;
	private static final int READ_PAUSE = 500;
	
	private final MyReadWriteLock myLock = new MyReadWriteLock();
	
	private final List<E> list = new ArrayList<>();
	
	public void add(E o) {
		String name = Thread.currentThread().getName();
		
		System.out.println(name + " add " + o + " start...");
		
		try {
			myLock.lockWrite();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(name + " add " + o + " write lock");
		
		try {
			
			TimeUnit.MILLISECONDS.sleep(WRITE_PAUSE);
			list.add(o);
			
			System.out.println(name + " add " + o + " done");			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				myLock.unlockWrite();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(name + " add " + o + " end...");
		
	}
	
	
	public E get(int i) {
		E res = null;
		String name = Thread.currentThread().getName();
		
		System.out.println(name + " get " + i + " start...");
		try {
			myLock.lockRead();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(name + " get " + i + " read lock");
		try {
			res = list.get(i);
			
			TimeUnit.MILLISECONDS.sleep(READ_PAUSE);
			
			System.out.println(name + " get " + i + " done");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			myLock.unlockRead();
		}
		return res;
	}
	
}
