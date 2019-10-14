/**
 * @author Katic
 *
 * @source: https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0
 */
package com.katic.amazon.medium;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubSeq {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n>0){
			n--;
		    int size = in.nextInt();
		    int[] a = new int[size];
		    for(int i=0;i<size;i++){
		        a[i] = in.nextInt();
		    }
		    int[] r = new int[size];
		    Arrays.fill(r,1);
		    int max = 0;
	        for(int i=1;i<size;i++){
		       int j=0;
		       while(j<i){
		           if(a[j]<a[i]){
		               r[i] = Math.max(r[i],r[j]+1);
		           }
		           j++;
		           if(r[i] > max){
		               max = r[i];
		           }
		       }
		    }
		    System.out.println(max);
		    
		}
	}
}
