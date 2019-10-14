package com.katic.amazon;

import java.util.Scanner;
/*******
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/subset-sum-problem/0
 */
public class SubsetSum_Recursion {
	private static boolean flag = false;
	
	public static void main(String...arg){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int s = in.nextInt();
			int[] a = new int[s];
			int sum=0;
			for(int i=0;i<s;i++){
				a[i] = in.nextInt();
				sum+=a[i];
			}
			if(sum%2!=0){
				System.out.println("NO");
				continue;
			}
			int[] r = new int[s];
			flag = false;
			checkSubSetwithSum(a,r,0,sum);
			if(flag){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

	private static void checkSubSetwithSum(int[] a, int[] r, int i,int sum) {
		if(i==a.length){
			return;
		}else{
			int tempSum = 0;
			for(int j=0;j<a.length;j++){
				if(r[j]==1){
					tempSum+=a[j];
					if(tempSum>sum){
						return;
					}
					if(tempSum == sum){
						flag = true;
						return;
					}
				}
			}
			r[i] = 0;
			checkSubSetwithSum(a, r, i+1,sum);
			r[i] =1;
			checkSubSetwithSum(a, r, i+1, sum);
		}
		
	}

}