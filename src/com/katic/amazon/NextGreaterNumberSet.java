package com.katic.amazon;

import java.util.Arrays;
import java.util.Scanner;

public class NextGreaterNumberSet {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		while(t>0){
			t--;
			char[] a = in.next().trim().toCharArray();
			boolean found = false;
			int i=a.length-1;
			int j=i-1;
			while(i>0 && j>=0){
				if(Integer.parseInt(String.valueOf(a[i]))>Integer.parseInt(String.valueOf(a[j]))){
					int d1 = Integer.parseInt(String.valueOf(a[j]));
					int k=a.length-1;
					int min = Integer.MAX_VALUE;
					int index = 0;
					while(k>j){
						if(Integer.parseInt(String.valueOf(a[k]))>d1 && Integer.parseInt(String.valueOf(a[k]))<min){
							index = k;
							min = Integer.parseInt(String.valueOf(a[k]));
						}
						k--;
					}
					char c = a[index];
					a[index] = a[j];
					a[j] = c;
					Arrays.sort(a,j+1,a.length);
					found=true;
					break;
				}
				i--;
				j--;
			}
			/*
			outer:for(int i=a.length-1;i>=0;i--){
				for(int j=i-1;j>=0;j--){
					if(Integer.parseInt(String.valueOf(a[i]))>Integer.parseInt(String.valueOf(a[j]))){
						char c = a[i];
						a[i] = a[j];
						a[j] = c;
						Arrays.sort(a,i,a.length);
						found=true;
						break outer;
					}
				}
			}*/
			if(found){
				System.out.println(String.valueOf(a));
			}else{
				System.out.println("not possible");
			}
		}
	}
}
