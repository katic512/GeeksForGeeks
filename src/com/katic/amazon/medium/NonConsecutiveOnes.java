package com.katic.amazon.medium;

import java.util.Scanner;
/*****
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/consecutive-1s-not-allowed/0
 */
public class NonConsecutiveOnes {
	private static int counter = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int n = in.nextInt();
			counter=0;
			int[] a = new int[n];
			recurse(a, n, 0);
			System.out.println(counter+1);
		}
	}
	private static void recurse(int[] a, int n, int i) {
		if(i>=n){
			//counter++;
			/*for(int k = 0;k<n;k++){
				System.out.print(a[k]+" ");
			}
			System.out.println();*/
			return;
		}
		for(int j = i; j<n;j++){
			a[j] = 1;
			counter++;
			recurse(a, n, j+2);
			a[j] = 0;
		}
	}

}
