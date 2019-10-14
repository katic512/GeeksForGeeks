package com.katic.amazon.hard;

import java.util.Scanner;

public class XtotalShapes {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int n = in.nextInt();
			int m = in.nextInt();
			char[][] a = new char[n][m];
			for(int i =0; i<n;i++){
				a[i] = in.next().trim().toCharArray();
			}
			int count = 0;
			for(int i =0; i<n;i++){
				for(int j=0;j<m; j++){
				    if(a[i][j] == 'X'){
				    	count++;
				        recurs(a, n, m, i, j );
				    }
				}
			}
			System.out.println(count);
		}
	}
	
	static void recurs(char[][] a, int n, int m, int i, int j){
	    if(i>=n || j>=m || i<0 || j<0)return;
	    if(a[i][j] !='X') return;
	    a[i][j] = 'O';
	    //recurs(a, n, m, i+1, j+1 );
	    //recurs(a, n, m, i+1, j-1 );
	    //recurs(a, n, m, i-1, j+1 );
	    //recurs(a, n, m, i-1, j-1 );
	    recurs(a, n, m, i+1, j );
	    recurs(a, n, m, i, j+1 );
	    recurs(a, n, m, i-1, j );
	    recurs(a, n, m, i, j-1 );
	}
}
