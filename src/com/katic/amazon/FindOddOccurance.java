package com.katic.amazon;

import java.util.Scanner;

public class FindOddOccurance {
	public static void main(String[] arg){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int s = in.nextInt();
			int[] a = new int[s];
			/*int[] r = new int[1001];
			int max=0;
			for(int i=0;i<s;i++){
				a[i] = in.nextInt();
				r[a[i]]++;
			}
			for(int i=0;i<s;i++){
				if(r[a[i]]%2!=0){
				    max=a[i];
				}
			}
			System.out.println(max);*/
			int sum = 0;
			for(int i=0;i<s;i++){
				a[i] = in.nextInt();
				sum = sum ^ a[i];
			}
			System.out.println(sum);
		}
	}
}
