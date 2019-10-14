package com.katic.amazon.medium;

import java.util.Scanner;

public class SumQuery1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int n = in.nextInt();
			long[] m = new long[n+1];
			for(int i =1;i<=n;i++){
					m[i] = (long)in.nextInt();
			}
			int q = in.nextInt();
			int[] l = new int[q+1];
			int[] r = new int[q+1];
			int index = 1;
			while(q>0){
				q--;
				l[index] = in.nextInt();
				r[index++] = in.nextInt();
			}
			long[][] s = new long[n+1][n+1];
			for(int i = 1;i<=n;i++){
				for(int j = i;j<=n;j++){
					/*if(i>j){
						s[i][j] = s[i-1][j];
						continue;
					}*/
					s[i][j] = s[i][j-1]+getSum(i,j,m);
				}
			}
			for(int i = 1;i<l.length;i++){
				System.out.print(s[l[i]][r[i]]+" ");
			}

			System.out.println();
		}
	}

	private static long getSum(int l, int i, long[] m) {
		long f1 = (i-l+1)*(i-l+1)*m[i];
		return f1;
	}
}


