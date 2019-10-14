package com.katic.amazon;

import java.util.Arrays;
import java.util.Scanner;

public class FindProduct {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n>0){
			n--;
			int size = in.nextInt();
			int num = in.nextInt();
			int[] a = new int[size];
			for(int i=0;i<size;i++){
				a[i] = in.nextInt();
			}
			Arrays.sort(a);
			boolean flag = false;
			for(int i=0;i<size && a[i]<=num;i++){
				if(binarySearch(num-a[i],a)){
					flag = true;
					break;
				}
			}
			if(flag){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
			
		}
	}

	private static boolean binarySearch(int n, int[] a) {
		int j = a.length-1;
		int i =0;
		while(j-i >1){
			int m = i+((j-i)/2);
			if(a[m] > n){
				j = m;
			}else if(a[m] < n){
				i = m;
			}else{
				return true;
			}
		}
		return false;
	}
	
	
}