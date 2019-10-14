package com.katic.amazon.medium;

import java.util.Scanner;
/*****
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/longest-prefix-suffix/0
 * 
 * @logic : set i = 0;j=1; till j<size;
 * 			if element at i and j are equal increase i and j, set current length at j = i +1;
 * 			if not
 * 				if i =0; meaning we cant further go left and increment j
 * 				else go to previous length location of i;
 */

public class PrefixSuffixMatch {

	public static void main(String[] ar){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			char[] a = in.next().trim().toCharArray();
			int[] l = new int[a.length];
			int size = a.length;
			int max = 0;
			int i = 0, j = 1;
			while(j<size){
				if(a[i]==a[j]){
					l[j] = i+1;
					if(l[j]>max)max=l[j];
					i++;j++;
				}else{
					if(i!=0){
						i=l[i-1];	
					}else{
						l[j]=0;
						j++;
					}
				}
			}
			System.out.println(max);		
		}
	}
}
