package com.katic.amazon;

import java.util.Scanner;

public class MaxSumWithoutAdjacent {

	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int s = in.nextInt();
			int[] a = new int[s];
			for(int i=0;i<s;i++){
				a[i] = in.nextInt();
			}
           int inc = 0;
           int exc = 0;
           for(int j=0;j<s;j++){
               if(j==0){
                   inc = a[j];
               }else{
                   int temp = Math.max(exc+a[j],inc);
                   exc = inc;
                   inc = temp;
               }
           }
           inc = exc>inc?exc:inc;
           System.out.println(inc);
		}
	}
}