package com.katic.amazon;

import java.util.Scanner;

public class MaxValue {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		while(t>0){
			t--;
			int s = in.nextInt();
			int[] a = new int[s];
			for(int i=0;i<s;i++){
				a[i] = in.nextInt();
			}
			int max = Integer.MIN_VALUE;
			for(int i=0;i<s-1;i++){
				for(int j=i+1;j<s;j++){
					int temp = Math.abs((a[i]-i)-(a[j]-j));
					System.out.println("i:"+i+" a[i]:"+a[i]+"  j:"+j+" a[j]:"+a[j] +"     temp:"+temp);
					if(temp>max)max=temp;
				}
			}
			System.out.println(max);
		}
	}
}
