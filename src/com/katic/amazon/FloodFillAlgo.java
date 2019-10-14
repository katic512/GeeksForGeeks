package com.katic.amazon;

import java.util.Scanner;

public class FloodFillAlgo {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] a = new int[n][m];
			for(int i =0; i<n;i++){
				for(int j=0;j<m; j++){
					a[i][j] = in.nextInt();
				}
			}
			int x = in.nextInt();
			int y = in.nextInt();
			int pr = in.nextInt();
			int ps = a[x][y];
			recur(a, x, y, n, m, ps, pr );
			for(int i =0; i<n;i++){
				for(int j=0;j<m; j++){
					System.out.print(a[i][j]+" ");
				}
			}
		}
	}

	static void recur(int[][] a, int x, int y, int n, int m, int ps, int pr){
		System.out.println("x:"+x +" y:"+y);
		if(x>=n || y>=m || x<0 || y<0)return;
		if(a[x][y] != ps) return;
		a[x][y] = pr;
		//only adjacent not diagonal
		recur(a, x+1, y, n, m, ps, pr);
		recur(a, x, y+1, n, m, ps, pr);
		//recur(a, x+1, y+1, n, m, ps, pr);
		recur(a, x-1, y, n, m, ps, pr);
		recur(a, x, y-1, n, m, ps, pr);
		//recur(a, x-1, y-1, n, m, ps, pr);
		//recur(a, x-1, y+1, n, m, ps, pr);
		//recur(a, x+1, y-1, n, m, ps, pr);
	}
}