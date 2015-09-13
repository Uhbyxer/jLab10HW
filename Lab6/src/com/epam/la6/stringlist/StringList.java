package com.epam.la6.stringlist;


public class StringList {
	private static final int DEFAULT_SIZE = 20;
	private int size = 0;
	private String[] arr; 
	
	public StringList() {
		arr = new String[DEFAULT_SIZE];
	}
	
	public int size() {
		return size;
	}
	
	public void add(String str) {
		if(arr.length < size + 1) {
			int newSize = arr.length * 2;
			//int newSize = arr.length *  3 / 2+1;
			
			String[] newArr = new String[newSize];
			System.arraycopy(arr, 0, newArr, 0, size);
			
			arr = new String[newSize];
			arr = newArr;
		}
		arr[size++] = str;
	}
	
	public String get(int index) {
		return arr[index];
	}
}
