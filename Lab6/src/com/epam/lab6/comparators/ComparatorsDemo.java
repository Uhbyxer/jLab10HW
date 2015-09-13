package com.epam.lab6.comparators;

import java.util.*;

import com.epam.lab6.io.ScannerSigleton;

public class ComparatorsDemo {
	
	public static void main(String[] args) {
		System.out.println("Enter size:");
		
		int size = ScannerSigleton.readPositiveInt();
		
		Country[] countryArr = new Country[size];
		
		CountryGenerator gen = new CountryGenerator(size);
		int i = 0;
		for(Country country: gen) 
			countryArr[i++] = country;
		
		System.out.println("\n======================\nArray of countries:\n");
		printArray(countryArr);
		
		List<Country> countryList = new ArrayList<>(Arrays.asList(countryArr));
		System.out.println("\n======================\nList of countries:\n");
		printList(countryList);
		
		Arrays.sort(countryArr);
		System.out.println("\n======================\nArray after sort by country name:\n");
		printArray(countryArr);
		
		Collections.sort(countryList);
		System.out.println("\n======================\nList after sort by country name:\n");
		printList(countryList);
		
		Arrays.sort(countryArr, Country.BY_CAPITAL_ORDER);
		System.out.println("\n======================\nArray after sort by capital name:\n");
		printArray(countryArr);
		
		countryList.sort(Country.BY_CAPITAL_ORDER);
		System.out.println("\n======================\nList after sort by capital name:\n");
		printList(countryList);
		
		System.out.println("\n======================");
		System.out.println("Enter country name:");
		String countryName = ScannerSigleton.readString();
		System.out.println("Enter capital name:");
		String capitalName = ScannerSigleton.readString();
		
		int index = Collections.binarySearch(countryList, new Country(countryName, capitalName), Country.BY_CAPITAL_ORDER);
		
		if(index < 0) System.out.println("Country not found !");
		else System.out.println("Position: " + index);
	}	
		
	
	public static void printArray(Object[] obj) {
		int i = 0;
		for(Object o: obj) 
			System.out.println((i++) + " --> " +  o.toString());
	}
	
	public static void printList(Collection<? extends Object> list) {
		int i = 0;
		for(Object l: list) 
			System.out.println((i++) + " --> " +  l.toString());
	}
	
	
}
