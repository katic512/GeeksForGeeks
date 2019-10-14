package com.katic.amazon.easy;

import java.util.Scanner;
/**
 * 
 * @author Katic
 *
 * @source: https://www.geeksforgeeks.org/maximum-product-subarray/
 */
public class MaximumProductSubArray {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int s = in.nextInt();
			int[] a = new int[s];
			for(int i=0;i<s;i++){
				a[i]=in.nextInt();
			}
			int[] r= new int[s];
			int finalmax;
			int max;
			int min;
			max=min=finalmax=r[0]=a[0];
			for(int i=1;i<s;i++){
				int minVal = min*a[i];
				int maxVal = max*a[i];
				min = Math.min(Math.min(minVal,maxVal),a[i]);
				max = Math.max(Math.max(minVal,maxVal),a[i]);
				r[i]=max;
				if(r[i]>finalmax)finalmax=r[i];
			}
			System.out.println(finalmax);
		}
	}

}