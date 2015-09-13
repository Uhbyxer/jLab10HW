package com.epam.lab7.integerlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerListDemo {

	public static void main(String[] args) {
		
		String[] arr = "Hello my dear friend !".split(" ");
		List<Integer> list = new ArrayList<>();
		
		System.out.println("Add strings to Integer List:");
		for(String str: arr) {
			System.out.println("\t" + str);
			addStringToIntegerList(list, str);
		}	
		
		System.out.println("Get strings from Integer List:");
		for(int i = 0; i < list.size(); i++) {
			String temp = getStrinFromIntegerList(list, i);
			System.out.println("\t" + temp);
		}
		
	}
	
	public static void addStringToIntegerList(List<Integer> list, String str) {
		char[] chars = str.toCharArray();
		list.add(chars.length);
		for(char ch: chars)
			list.add((int) ch);
	}
	
	public static String getStrinFromIntegerList(List<Integer> list, int index) {
		String res = "";
		
		for(int i = 0, strIndex = 0; i < list.size(); strIndex++) {
			int k = list.get(i);
			
			if(strIndex == index) {
				List<Integer> temp = list.subList(i + 1, i + 1 + k);
				for(int j: temp) {
					char ch = (char) j;
					res += ch;
				}
				break;
				
			}
			i += k + 1;
		}
		
		return res;
	}

}
