package com.katic.amazon.medium;

import java.util.Scanner;
/**
 * 
 * @author Katic
 *
 * @source:	https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle/0
 */
public class EggDropPuzzle {

	public static void main(String [] arg){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int e = in.nextInt();
			int f = in.nextInt();
			int[][] a = new int[e+1][f+1];
			for(int i=1;i<=e;i++){
				for(int j=1; j<=f;j++){
					if(i==1){
						a[i][j]=j;
					}else if(i>j){
						a[i][j] = a[i-1][j];
					}else{
						int min = Integer.MAX_VALUE;
						for(int k = 1;k<=j;k++){
							int eBreak = -1;
							int enBreak = -1;
							if(k==1){
								eBreak = 0;
								enBreak = a[i][j-1];
							}else if(k == j){
								eBreak = a[i-1][j-1];
								enBreak = 0;
							}else{
								eBreak = a[i-1][k-1];
								enBreak = a[i][j-k];
							}
							int temp = 1+ Math.max(eBreak, enBreak);
							if(temp<min)min = temp;
						}
						a[i][j] = min;
					}
				}
			}
			System.out.println(a[e][f]);
		}
	}
}
