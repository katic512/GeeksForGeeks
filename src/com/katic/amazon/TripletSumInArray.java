package com.katic.amazon;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/triplet-sum-in-array/0
 * 
 * @logic:	1) Sort the input array.
			2) Fix the first element as A[i] where i is from 0 to array size – 2. After fixing the first element of triplet, find the other two elements using two pointer method
 */
public class TripletSumInArray {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int s = in.nextInt();
			int n = in.nextInt();
			int[] a = new int[s];
			for(int i=0;i<s;i++){
				a[i]=in.nextInt();
			}
			Arrays.sort(a);
			int j=s-1;
			int ans=0;
			outer:while(j>=2){
				if(a[j]>=n){
					j--;
					continue;
				}
				int i=0;
				while(i<j-1){
					int q=i;
					int k=n-(a[j]+a[q]);
					if(k<a[q]){
						j--;
						continue outer;
					}
					q++;
					while(q<j && a[q]<=k){
						if(a[q]==k){
							ans=1;
							break outer;
						}
						q++;
					}
					i++;
				}
				j--;
			}
			System.out.println(ans);
		}
	}
}
