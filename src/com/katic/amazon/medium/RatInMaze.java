/**
 * @author Katic
 *
 * @source: 
 */
package com.katic.amazon.medium;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RatInMaze {

	static Set<String>  ans;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int n = in.nextInt();
			int[][] m = new int[n][n];
			ans = new TreeSet<>();
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					m[i][j] = in.nextInt();
				}
			}
			int[][] v = new int[n][n];
			traverse(m , n, 0 , 0, "", v);
			for(String st:ans){
				System.out.println(st);
			}
		}
	}

	private static void test(int[][] v, int n, String s) {
		for(int i=0;i<n; i++){
			for(int j=0;j<n; j++){
				System.out.print(v[i][j]+",");
			}
		}
		System.out.println(s);
	}

	private static void traverse(int[][] m, int n, int i, int j, String string, int[][] v ) {
		if(outOfBound(i,j,n, v) || m[i][j] == 0){
			return;
		}
		if(i==n-1 && j==n-1){
			System.out.println(string);
			ans.add(string);
			return;
		}

		v[i][j] = 1;
		traverse(m, n, i-1, j, string+"U", v);
		test(v, n, string);
		traverse(m, n, i+1, j, string+"D", v);
		test(v, n, string);
		traverse(m, n, i, j-1, string+"L", v);
		test(v, n, string);
		traverse(m, n, i, j+1, string+"R", v);
		test(v, n, string);
	}

	private static boolean outOfBound(int i, int j, int n, int[][] v) {
		if(i>=0 && i< n && j>=0 && j<n && v[i][j]==0) return false;
		return true;
	}

	
	
	

}
