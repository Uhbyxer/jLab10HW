package com.epam.tgrynchuk.lab4.minesweeper;

import java.util.Random;

import com.epam.tgrynchuk.lab4.ScannerSigleton;

public class Minesweeper {

	public static void main(String[] args) {
		System.out.println("Enter M (M >= 2): ");
		int m = ScannerSigleton.readInt();
		if (m < 2) {
			System.err.println("Error! M < 2 !");
			return;
		}
		System.out.println("Enter N (N >= 2): ");
		int n = ScannerSigleton.readInt();
		if (n < 2) {
			System.err.println("Error! M < 2 !");
			return;
		}		
		System.out.println("Enter p (0 <= p <= 100): ");
		int p = ScannerSigleton.readInt();
		if (p < 0 || p > 100) {
			System.err.println("Error! p not in (0 <= p <= 100) !");
			return;
		}		

		boolean[][] matrix = new boolean[m + 2][n + 2];
		for(int i=0; i<=m+1; i++)
			for(int j=0; j<=n+1; j++)
				matrix[i][j] = false;
		
		for(int i=1; i<m+1; i++)
			for(int j=1; j<n+1; j++) {
				matrix[i][j] = new Random().nextInt(100) < p;
			}

		System.out.println("Mines:");
		for(int i=1; i<m+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(matrix[i][j] ) System.out.print("*"); else System.out.print("-"); 
				System.out.print("|");
			}
			System.out.println();
		}
		
		System.out.println("\nResult:");
		for(int i=1; i<m+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(matrix[i][j]) System.out.print("*|");
				else {
					int k = checkCell(matrix, i, j);
					System.out.print(k + "|");
				}
			}
			System.out.println();
		}
		
	}
	
	static int checkCell(boolean[][] matrix, int row, int col) {
		int res = 0;
		
		for(int i = row - 1; i <= row + 1; i++) {
			for(int j = col - 1; j <= col + 1; j++) {
				if(i == row && j == col) continue;
				
				if(matrix[i][j]) res++;
			}
		}
		
		return res;
	}

}
