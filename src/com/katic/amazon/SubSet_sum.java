/**
 * @author Katic
 *
 * @source: https://practice.geeksforgeeks.org/problems/subset-sum-problem/0
 */
package com.katic.amazon;

import java.util.Arrays;
import java.util.Scanner;

public class SubSet_sum {
	
	private static boolean flag;
	public static void main(String...a){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int n = in.nextInt();
			int[] ar = new int[n];
			int sum = 0;
			for(int i=0;i<n;i++){
				ar[i] = in.nextInt();
				sum+=ar[i];
			}
			if(sum%2!=0){
				System.out.println("NO");continue;
			}
			Arrays.sort(ar);
			flag = false;
			int i = 0,j = n-1;
			/*int tempSum = 0;
			while(j>0){
				tempSum += ar[j];
				if(sum-tempSum==tempSum){
					flag = true;
					break;
				}
				j--;
			}*/
			// if two sets have equal sum then it will be equal to sum/2
			//sum=32;
			combinationSum(ar, 0, n, 0, sum/2);
			if(flag){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
	
	private static void combinationSum(int[] ar,int start, int n,int currSum, int sum){
		if(start>n)return;
		if(currSum>sum)return;
		if(currSum==sum){
			flag = true;
			return;
		}
		for(int i = start;i<n;i++){
			if(ar[i]!=-1){
				int temp = ar[i];
				ar[i]=-1;
				combinationSum(ar, i, n, currSum+temp, sum);
				ar[i]=temp;
			}
		}
	}

}
