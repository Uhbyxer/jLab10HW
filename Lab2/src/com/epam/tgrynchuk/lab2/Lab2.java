package com.epam.tgrynchuk.lab2;

import java.util.Scanner;

//����-����� ����� � ��������

public class Lab2 {
	private static Scanner sc = new Scanner(System.in);
	
	//��������� ����� � ������
	public static int readIntNumber(String message) {
        System.out.print(message);
		if(!sc.hasNextInt())  terminateProgram("It's not integer value! Program terminate...");
		
		return sc.nextInt();
	}
	
	//������� ��������
	public static void terminateProgram(String errorMessage) {
		System.err.println(errorMessage);
		System.exit(1);
	}

	//�����...
	public static void main(String[] args) {
		
		System.out.println("Enter interval:");
        int from = readIntNumber("From: ");
        int to = readIntNumber("To: ");
        
        //����� ���� �� ���� ���� ����� �� ������
        if(from > to) terminateProgram("Invalid interval! Program terminate...");
        
        //����� ��������� ����� OddEven 
        OddEven oddEven = new OddEven(from, to);
        
        //���������� ���� ��������
        int oddSum = 0;
        System.out.println("Odd from start to end: ");
        for(int oe: oddEven) {
        	System.out.println(oe);
        	oddSum += oe;
        }
        
        
        //���������� ���� ������
        int evenSum = 0;
        System.out.println("Even from end to start: ");
        for(int oe: oddEven.getEvenFromEndToStart()) {
        	System.out.println(oe);
        	evenSum += oe;
        }
        
        System.out.printf("The sum of odd: %d\nThe sum of even: %d", oddSum, evenSum);
        
        //Fibonacci
        int n = readIntNumber("\n\nEnter the size of Fibonacci set: ");
        if(n < 1) terminateProgram("Invalid size! Program terminate...");
      
        Integer f1 = null, f2 = null;
        
        //�-��� ��������
        int oddCount = 0;
        
		Fibonacci fibonacci = new Fibonacci(n);
		for(int fib: fibonacci) {
			System.out.println(fib);
			if(fib % 2 == 0) f2 = fib; else {
				f1 = fib;
				oddCount++;
			}
		}
        System.out.printf("\nF1: %d\nF2: %d", f1, f2);
        int oddPercent = Math.round((float) oddCount / n * 100); 
        System.out.printf("\nOdd percent: %d\nEven percent: %d", oddPercent, 100 - oddPercent);
		
        
 	}

}
