package com.katic.amazon.medium;

import java.util.Scanner;
/**
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/trapping-rain-water/0
 * 
 * @logic: find max from left to right and right to left in two diff arrays. Now for any given index min of both rmax and lmax minus a[i]
 */
public class TrappingRainWater {
	
	public static void main(String[] ar){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int size = in.nextInt();
			int[] a = new int[size];
			int[] lMax = new int[size];
			int[] rMax = new int[size];
			for(int i=0;i<size;i++){
				a[i] = in.nextInt();
			}
			
			int lmax = a[0];
			lMax[0] = lmax;
			for(int i=1;i<size;i++){
				lMax[i] = lmax;
				if(lmax<a[i]){
					lmax = a[i];
				}
			}
			
			int rmax = a[size-1];
			rMax[size-1] = rmax;
			for(int i=size-2;i>=0;i--){
				rMax[i] = rmax;
				if(rmax < a[i]){
					rmax = a[i];
				}
			}
			
			int sum = 0;
			for(int i=0;i<size;i++){
				int v =Math.min(lMax[i], rMax[i])-a[i];
				if(v>0){
					sum+=v;
				}
			}
			
			System.out.println(sum);
		}
	}
}
