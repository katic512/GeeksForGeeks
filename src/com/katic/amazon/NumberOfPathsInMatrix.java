package com.katic.amazon;

import java.util.Scanner;
/****
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/number-of-unique-paths/0
 */
public class NumberOfPathsInMatrix {

	public static void main(String[] arg){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int m = in.nextInt();
			int n = in.nextInt();
			int[][] matrix = new int[m][n];
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					if(i==0 || j==0){
						matrix[i][j]=1;
					}else{
						matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];
					}
				}
			}
			System.out.println(matrix[m-1][n-1]);
		}
	}
}
