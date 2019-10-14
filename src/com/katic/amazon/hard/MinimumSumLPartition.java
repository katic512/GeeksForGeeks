package com.katic.amazon.hard;

import java.util.Arrays;
import java.util.Scanner;
/***
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/minimum-sum-partition/0
 * 
 * @logic: DP similar to coin change problem
 */
public class MinimumSumLPartition {
	private static int minDiff = 0;
	public static void main(String[] ar){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			 minDiff = Integer.MAX_VALUE;
			int size = in.nextInt();
			int[] a = new int[size];
			int sum = 0;
			for(int i=0;i<size;i++){
				a[i] = in.nextInt();
				sum+= a[i];
			}
			//greedy(size, a, sum);
			//recursion(size, a, sum);
			dp(size, a, sum);
			System.out.println("minDiff::"+minDiff);
		}
	}
	
	private static void dp(int size, int[] a, int sum) {
		int[] r = new int[sum+1];
		r[0] = 1;
		for(int i=0;i<size;i++){
			int[] temp= new int[sum+1];
			temp[0] =1;
			for(int j=1;j<sum;j++){
				if(a[i]>j || r[j]==1){
					temp[j] = r[j];
				}else if(r[j-a[i]]==1){
					temp[j] = 1;
					System.out.println("sums:"+j);
					if(Math.abs(sum-j-j)<minDiff){
						minDiff =Math.abs(sum-j-j);
					}
				}
			}
			r = temp;
		}
	}

	private static void recursion(int size, int[] a, int sum) {
		int m = size/2;
		int[] r = new int[size];
		while(m>0 && minDiff!=0){
			recurse(r,m,size, a,sum,-1,0);
			m--;
		}
		System.out.println("minDiff::"+minDiff);
	}

	private static void recurse(int[] r, int m, int size, int[] a, int sum, int startIndex, int oneCount) {
			//if(minDiff==0 )return;
			
			if(oneCount==m){
				int tempSum = 0;
				for(int j=0;j<size;j++){
					if(r[j]==1){
						tempSum+=a[j];
						System.out.print(a[j]+" ");
					}
				}
				if(Math.abs(sum-tempSum-tempSum)<minDiff)minDiff = Math.abs(sum-tempSum-tempSum);
				System.out.println();
				return;
			}
			if((startIndex-1+m-oneCount)>=size)return;
			
			
			for(int i=startIndex+1;i<size;i++){
				r[i]=1;
				recurse(r, m, size, a, sum, i, oneCount+1);
				r[i]=0;
			}
		
	}

	private static void greedy(int size, int[] a, int sum){

		Arrays.sort(a);
		for(int i=0;i<size;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		int tempDiff =0;
		int i = -1;
		int j = size-1;
		int prevDiff = Integer.MAX_VALUE;
		int prevSum = 0;
		while(i<j){
			if(i==-1){
				tempDiff = Math.abs((sum-a[j])-a[j]);
				i++;
				prevDiff = tempDiff;
				prevSum = a[j];
			}else{
				prevSum+=a[i];
				tempDiff = Math.abs((sum-prevSum)-prevSum);
				if(prevDiff<tempDiff){
					break;
				}else{
					prevDiff = tempDiff;
				}
				i++;
			}
		}
		i=size-1;
		int secondDiff=Integer.MAX_VALUE;
		int tempSum=0;
		while(i>0){
			tempSum+=a[i--];
			if(Math.abs(sum-tempSum)<secondDiff){
				secondDiff = Math.abs(sum-tempSum);
			}else{
				break;
			}
		}
		prevDiff = (prevDiff>secondDiff)?secondDiff:prevDiff;
		System.out.println(prevDiff);

	}
}
