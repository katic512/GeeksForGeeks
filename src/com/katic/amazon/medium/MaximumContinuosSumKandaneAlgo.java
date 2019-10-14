package com.katic.amazon.medium;

import java.util.Scanner;
/***
 * 
 * @author Katic
 *
 * @source: https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class MaximumContinuosSumKandaneAlgo {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
			int t = in.nextInt();
			while(t>0){
			    t--;
			    int s = in.nextInt();
			    int[] a = new int[s];
			    for(int i=0;i<s;i++){
			        a[i]=in.nextInt();
			    }
			    /***
			     * 
			     */
			    int[] r = new int[s];
			    r[0]=a[0];
			    int max = a[0];
			    for(int i=1;i<s;i++){
			        r[i] = Math.max(a[i],r[i-1]+a[i]);
			        if(r[i]>max)max=r[i];
			    }
			    System.out.println(max);
			}
		}
}
