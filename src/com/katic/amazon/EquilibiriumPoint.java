package com.katic.amazon;

import java.util.Scanner;

public class EquilibiriumPoint {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int s = in.nextInt();
			int[] a = new int[s];
			int rightSum =0;
			for(int i=0;i<s;i++){
				a[i]=in.nextInt();
				rightSum+=a[i];
			}
			int eqPoint=-1;
			if(s==1){
				eqPoint=1;
			}else{
				int leftSum=0;
				for(int i=0;i<s;i++){
					rightSum-=a[i];
					if(leftSum==rightSum){
						eqPoint=i+1;break;
					}
					leftSum+=a[i];
				}
			}
			System.out.println(eqPoint);
		}
	}
}
