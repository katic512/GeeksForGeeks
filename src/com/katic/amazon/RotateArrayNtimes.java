package com.katic.amazon;

import java.util.Scanner;

public class RotateArrayNtimes {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int s = in.nextInt();
			int d = in.nextInt();
			int[] a = new int[s];
			for(int i=0;i<s;i++){
				a[i]=in.nextInt();
			}
			d%=s;
			String temp ="";
			int j=d;
			while(j<s){
				temp+=a[j++]+" ";
			}
			int i=0;
			while(i<d){
				temp+=a[i++]+" ";
			}
			System.out.println(temp);
		}
	}
}
