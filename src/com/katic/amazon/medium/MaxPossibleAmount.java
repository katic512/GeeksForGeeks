/**
 * @author Katic
 *
 * @source: http://practice.geeksforgeeks.org/problems/max-possible-amount/0
 */
package com.katic.amazon.medium;

import java.util.Scanner;

public class MaxPossibleAmount {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int  t = in.nextInt();
		while(t>0){
			t--;
			int s = in.nextInt();
			int[] a = new int[s];
			int[] f = new int[s];
			int[] l = new int[s];
			for(int i =0;i<a.length;i++){
				a[i] = in.nextInt();
				if(i==0){
					f[i] = a[i];
				}else{
					if(f[i-1]<l[i-1]){
						f[i] = f[i-1]+a[i];
						l[i] = l[i-1];
					}else{
						f[i] = l[i-1]+a[i];
						l[i] = f[i-1];
					}
				}
			}
			System.out.println(f[s-1]);
			
		}
	}

}
