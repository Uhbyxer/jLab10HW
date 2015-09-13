package com.epam.lab8.streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestStreams {
	//public static final long BYTES = 200 * 100000;
	public static final long BYTES = 100;

	public static void main(String[] args)  {
		
		byte[] arr = new byte[]{1,2,3,4,5,6,7,8,9,0};

		
		System.out.println("FileOutputStream test");
		long start = System.currentTimeMillis();
		try(OutputStream out = new FileOutputStream(new File("testfile.dat"))) {
			
			
			for(int i = 0; i < BYTES; i++) {
				out.write(arr);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long stop = System.currentTimeMillis();
		System.out.printf("FileOutputStream: %d millis\n", stop - start);			
		
		System.out.println("============================================");
		System.out.println("FileInputStream test");
		start = System.currentTimeMillis();
		try(InputStream in = new FileInputStream(new File("testfile.dat"))) {
			while(in.read(arr) != -1); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stop = System.currentTimeMillis();
		System.out.printf("FileInputStream: %d millis\n", stop - start);
		
		System.out.println("============================================");
		System.out.println("BufferedWriter test");
		
		char[] chars = "1234567890".toCharArray();
		int buf = Integer.MAX_VALUE;
		
		start = System.currentTimeMillis();
		
		try(BufferedWriter out = new BufferedWriter(new FileWriter(new File("buftest.dat")))) {
			for(int i = 0; i < BYTES; i++) 
				out.write(chars);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stop = System.currentTimeMillis();
		System.out.printf("BufferedWriter: %d millis\n", stop - start);
		
		System.out.println("============================================");
		System.out.println("BufferedReader test");
		start = System.currentTimeMillis();
		
		
		try(BufferedReader in = new BufferedReader(new FileReader(new File("buftest.dat")))) {
			
			while(in.read(chars) != -1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stop = System.currentTimeMillis();
		System.out.printf("BufferedReader: %d millis\n", stop - start);
	}

}
