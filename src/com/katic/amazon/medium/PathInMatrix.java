package com.katic.amazon.medium;

import java.util.Scanner;
/***
 * 
 * @author Katic
 *
 * @source:https://www.geeksforgeeks.org/maximum-path-sum-matrix/
 */
public class PathInMatrix {
	public static void main(String[] ar){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int n = in.nextInt();
			int[][] m = new int[n][n];
			for(int i =0;i<n;i++){
				for(int j =0;j<n;j++){
					m[i][j] = in.nextInt();
				}
			}
			int[][] rm = new int[n][n];
			int max = Integer.MIN_VALUE;
			for(int i =0;i<n;i++){
				for(int j =0;j<n;j++){
					int v1 = m[i][j]+checkAndSetVal(i-1,j,n,rm);
					int v2 = m[i][j]+checkAndSetVal(i-1,j-1,n,rm);
					int v3 = m[i][j]+checkAndSetVal(i-1,j+1,n,rm);
					rm[i][j] = Math.max(Math.max(v1,v2), v3);
					if(i==n-1 && rm[i][j]>max){
						max = rm[i][j];
					}
				}
			}
			System.out.println(max);
		}
	}

	private static int checkAndSetVal(int i, int j, int n, int[][] m) {
		if(i>=0 && i<n && j>=0 && j<n)return m[i][j];
		return 0;
	}
}
