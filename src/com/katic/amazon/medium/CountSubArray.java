package com.katic.amazon.medium;

import java.util.Scanner;

public class CountSubArray {
	private static int count = 0;
	public static void main(String[] ar){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			 count = 0;
			int size = in.nextInt();
			int k = in.nextInt();
			int[] a = new int[size];
			int sum = 0;
			for(int i=0;i<size;i++){
				a[i] = in.nextInt();
				sum+= a[i];
				if(a[i]>k){
					count++;
				}
			}
			outer:for(int i = 0;i<size-1;i++){
				for(int j = i+1;j<size;j++){
					if((a[i]+a[j])>k){
						count+= size-j;
						continue outer;
					}
				}
			}
			//dp(size, a, sum, k);
			System.out.println(count);
		}
	}
	
	private static void dp(int size, int[] a, int sum, int k) {
		int[] r = new int[sum+1];
		r[0] = 1;
		for(int i=0;i<size;i++){
			int[] temp= new int[sum+1];
			temp[0] =1;
			for(int j=1;j<=sum;j++){
				if(a[i]>j || r[j]==1){
					temp[j] = r[j];
				}else if(r[j-a[i]]==1){
					temp[j] = 1;
					if(j>k){
						count++;
						System.out.println("sums:"+j);
					}
				}
			}
			r = temp;
		}
	}
}
