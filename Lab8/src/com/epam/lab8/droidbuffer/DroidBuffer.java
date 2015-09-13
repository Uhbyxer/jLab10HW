package com.epam.lab8.droidbuffer;

import java.util.ArrayList;
import java.util.List;

public class DroidBuffer {
	private int capacity;
	private int position;
	private int limit;
	
	private Droid[] holder; 
	
	public DroidBuffer(int capacity) {
		super();
		this.capacity = capacity;
		holder = new Droid[capacity];
		
		
		position = 0;
		limit = capacity;
	}
	
	public void write(Droid droid) {
		holder[position++] =  droid; 
		//System.out.println(position + " = "+ droid);
	}
	
	public Droid read() {
		return holder[position++];
	}

	public void flip() {
		limit = position;
		position = 0;
	}
	
	public void clear() {
		position = 0;
		limit = capacity;
	}

	public static void main(String[] args) {
		DroidBuffer buf = new DroidBuffer(100);
		for(int i = 0; i < 20; i++) {
			Droid d = new Droid(i);
			System.out.println("adding to buffer " + d);
			buf.write(d);
		}
		
		System.out.println("\ngetting 10 droids from buffer ");
		buf.flip();
		for(int i = 0; i < 10; i++) {
			Droid d = buf.read();
			System.out.println(d);
		}
		
		System.out.println("\nnew 10 droids to buffer: ");
		buf.clear();
		for(int i = 20; i < 30; i++) {
			Droid d = new Droid(i);
			buf.write(d);
			System.out.println(d);
		}
		
		System.out.println("\ngetting 10 droids from buffer ");
		buf.flip();
		for(int i = 0; i < 10; i++) {
			Droid d = buf.read();
			System.out.println(d);
		}
	}
}
