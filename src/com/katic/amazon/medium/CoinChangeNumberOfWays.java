package com.katic.amazon.medium;

import java.util.Scanner;
/**
 * 
 * @author Katic
 *
 * @source: https://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 */
public class CoinChangeNumberOfWays {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int s = in.nextInt();
		int[] a = new int[s];
		for(int i=0;i<s;i++){
			a[i]=in.nextInt();
		}
		long[] r = new long[n+1];
		r[0]=1;
		for(int i=0;i<s;i++){
			long[] temp = new long[n+1];
			temp[0]=1;
			for(int j=1;j<=n;j++){
				if(a[i]>j){
					temp[j] = r[j];
                }else if(temp[j-a[i]]>=1){
					temp[j]=temp[j-a[i]]+r[j];
				}else{
					temp[j] = r[j];
				}
			}
			r=temp;
			for(int q=0;q<r.length;q++){
				System.out.print(r[q]+",");
			}
			System.out.println();
		}
		System.out.println(r[n]);
	}
}