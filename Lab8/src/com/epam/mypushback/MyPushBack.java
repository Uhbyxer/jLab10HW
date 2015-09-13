package com.epam.mypushback;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyPushBack implements AutoCloseable{
	private FileReader in;
	private LinkedList<Character> buff;
	private int size;
	private int maxsize;
	private int pointer = -1;
	
	
	
	public MyPushBack(FileReader in, int size) {
		this.in = in;
		this.size = size;
		this.maxsize = size;
		buff = new LinkedList<Character>();
	}
	
	public Character read() throws IOException {
		int res = 0;
		if(buff.isEmpty() || (pointer  == size)) {
			buff.clear();
			char[] chars = new char[maxsize];
			res = in.read(chars);
			if(res == -1) return null;
			size = res;
			
			for(int i = 0; i < size; i++) {
				buff.add(chars[i]);
			}
	
			
			pointer = 0;
		}
		
		Character ch = buff.get(pointer++);
		return ch;
	}
	
	public void unread(Character ch) {
		buff.addFirst(ch);
		size++;
	}
	

	@Override
	public void close() throws IOException {
		in.close();
		
	}
	
	
	
	public static void main(String[] args) {
		
		try(MyPushBack in = new MyPushBack(new FileReader("testMyPush"),2)) {
			
			Character ch = null;
			while((ch = in.read()) != null) {
				
				if(ch == '<') {
					//System.out.print(ch);
					
					Character next = in.read();
					if(next == '>')
						System.out.print("!=");
					else { 
						in.unread(next);
						System.out.print(ch);
					}	
					
					
				} else {
					System.out.print(ch);
				}
				
				/*
				try{
				TimeUnit.MILLISECONDS.sleep(10);
				}catch(Exception e) {
					
				}
				*/
				
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
