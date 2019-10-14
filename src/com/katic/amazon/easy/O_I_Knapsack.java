/**
 * @author Katic
 *
 * @source: http://practice.geeksforgeeks.org/problems/0-1-knapsack-problem/0
 */
package com.katic.amazon.easy;

import java.util.Scanner;

public class O_I_Knapsack {
	
	public static void main(String[] ar){
		Scanner in = new Scanner (System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int s = in.nextInt();
			int k = in.nextInt();
			int[] w = new int[s+1];
			int[] v = new int[s+1];
			for(int i=1;i<=s;i++){
				v[i] = in.nextInt();
			}
			for(int i=1;i<=s;i++){
				w[i] = in.nextInt();
			}
			int[] r = new int[k+1];
			for(int i = 1;i<s+1;i++){
				int[] temp = new int[k+1];
				for(int j = 1;j<k+1;j++){
					if(w[i]>j){
						temp[j] = r[j];
					}else{
						int tempM = Math.max(v[i]+r[j-w[i]], r[j]);
						temp[j]= tempM;
					}
				}
				r = temp;
			}
			System.out.println(r[k]);
		}
	}

}
