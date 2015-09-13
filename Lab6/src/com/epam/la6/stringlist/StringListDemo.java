package com.epam.la6.stringlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringListDemo {
	public static final int COUNT = 50000;
	
	
	public static void test1() {
		System.out.println("test 1 ----------------->");
		StringList myList = new StringList();
		List<String> arrList = new ArrayList<>();
		
		DaysGenerator gen = new DaysGenerator(5000000);
		
		//====================================
		long arrStart = System.currentTimeMillis();
		
		for(String g: gen)
			arrList.add(g);
		
		long arrStop = System.currentTimeMillis();
		System.out.printf("ArrayList: %d millis\n", arrStop - arrStart);		
		
		//====================================
		long myStart = System.currentTimeMillis();
		
		for(String g: gen)
			myList.add(g);
		
		long myStop = System.currentTimeMillis();
		System.out.printf("StringList: %d millis\n", myStop - myStart);
	}
	
	public static void test2() {
		System.out.println("test 2 ----------------->");
		
		int[] sizeOfStr = new int[COUNT];
		for(int i = 0; i < COUNT; i++) {
			sizeOfStr[i] = new Random().nextInt(50);
		}
		
		StringList myList = new StringList();
		List<String> arrList = new ArrayList<>();
		

		
		
		//====================================
		long arrStart = System.currentTimeMillis();
		for(int i = 0; i < COUNT; i++) {
			arrList.add(generateString(sizeOfStr[i]));
		}
		long arrStop = System.currentTimeMillis();
		System.out.printf("ArrayList: %d millis\n", arrStop - arrStart);
		
		//====================================
		long myStart = System.currentTimeMillis();
		
		for(int i = 0; i < COUNT; i++) {
			myList.add(generateString(sizeOfStr[i]));
		}
		
		long myStop = System.currentTimeMillis();
		System.out.printf("StringList: %d millis\n", myStop - myStart);
		
	}

	public static void main(String[] args) {
		test1();
		test2();
		
		
	}
	
	public static String generateString(int size) {
		String res = "";
		for(int i = 0; i < size; i++) {
			int index = new Random().nextInt(Alphabet.length());
			res += Alphabet.substring(index, index);
		}
		return res;
	}
	
	private static String Alphabet;
	
	static {
		for(char ch = 'a'; ch < 'z'; ch++) 
			Alphabet += ch;
	}

}
