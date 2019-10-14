package com.katic.amazon.medium;

import java.util.Scanner;
/****
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix/0
 */
public class LargestSqrBinaryMatrix {
	
	private static int max = 0;
	public static void main(String[] ar){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			max = 0;
			int r = in.nextInt();
			int c = in.nextInt();
			int[][] m = new int[r][c];
			for(int i =0;i<r;i++){
				for(int j =0;j<c;j++){
					m[i][j] = in.nextInt();
					updateM(i, j, m, r, c);
				}
			}
			System.out.println(max);
		}
	}

	private static void updateM(int i, int j, int[][] m, int r, int c) {
		if(i-1>=0 && i-1<r && j-1>=0 && j<c ){
			int temp = Math.min(Math.min(m[i-1][j-1], m[i-1][j]),m[i][j-1]);
			if(temp>0 && m[i][j]>0){
				m[i][j] = ++temp;
				if(temp>max)max = temp;
			}
		}
	}

	
}
