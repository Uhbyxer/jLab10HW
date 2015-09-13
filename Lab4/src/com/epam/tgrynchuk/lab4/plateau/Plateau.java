package com.epam.tgrynchuk.lab4.plateau;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import com.epam.tgrynchuk.lab4.ScannerSigleton;

public class Plateau implements Comparable<Plateau> {
	
	private int firstIndex, lastIndex;
	private int value;

	public int getFirstIndex() {
		return firstIndex;
	}


	public int getLastIndex() {
		return lastIndex;
	}
	
	public int getValue() {
		return value;
	}

	public Plateau(int firstIndex, int lastIndex, int value) {
		super();
		this.firstIndex = firstIndex;
		this.lastIndex = lastIndex;
		this.value = value;
	}

	public Integer getSize() {
		return lastIndex - firstIndex + 1; 
	}
	
	@Override
	public String toString() {
		int[] a = new int[getSize()];
		Arrays.fill(a, value);
		String res = Arrays.toString(a);
		res += " Size: " + getSize() + " Location: from " + firstIndex + " to " + lastIndex;
		return res;
	}

	public static void main(String[] args) {
		
		System.out.println("Enter size of array:");
		int size = ScannerSigleton.readInt();
		if(size < 1) {
			System.err.println("Error! size < 1 !");
			return;
		}
		
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			System.out.printf("[%d]: ", i);
			arr[i] = ScannerSigleton.readInt();
		}
		
		LinkedList<Plateau> plateauList = new LinkedList<>();
		
		for(int i = 1; i < size - 1; i++) {
			//перевірка лівого сусіда
			if(!(arr[i - 1] < arr[i])) continue;
			
			for(int j = i + 1; j < size - 1; j++) {
				if(arr[i] != arr[j]) break;
				
				if(arr[j + 1] < arr[j]) {
					//це плато
					plateauList.add(new Plateau(i, j, arr[i]));
				}
			}
		}
		
		if(plateauList.size() == 0) {
			System.out.println("No plateau !");
			return;
		}
		
		//сортуємо в порядку спадання довжини
		Collections.sort(plateauList);
		
		for(Plateau p: plateauList) {
			//якщо є плато з одинаковою довжиною
			if(p.getSize() != plateauList.getFirst().getSize()) break;
			
			System.out.println(p);
		}
		
	}

	@Override
	public int compareTo(Plateau p) {
		return p.getSize().compareTo(getSize());
	}

}
