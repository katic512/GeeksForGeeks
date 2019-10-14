package com.katic.amazon.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/***
 * 
 * @author Katic
 *
 * @source: https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
 */
public class ShortestDistance {
	public static void main (String[] args) {
		Scanner in  = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] a = new int[n][m];
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					a[i][j] = in.nextInt(); 
				}
			}
			int d1 = in.nextInt();
			int d2 = in.nextInt();
			if(a[0][0] == 0){
				System.out.println(-1);
				continue;
			}
			int steps=0;
			Queue<Integer> i1 = new LinkedList<>();
			Queue<Integer> i2 = new LinkedList<>();
			i1.add(0);
			i2.add(0);
			boolean flag = true;
			while(i1.size()>0){
				int size = i1.size();
				while(size>0){
					size--;
					int x = i1.remove();
					int y = i2.remove();
					if(x==d1 && y==d2){
						System.out.println(steps);
						flag = false;
						break;
					}
					mod(x,y-1, n, m, a, i1, i2);
					mod(x,y+1, n, m, a, i1, i2);
					mod(x-1,y, n, m, a, i1, i2);
					mod(x+1,y, n, m, a, i1, i2);
				}
				steps++;
				if(!flag)break;
			}
			if(flag) { System.out.println(-1);}
		}

	}

	static void mod(int x, int y, int n, int m, int[][] a, Queue<Integer> i1, Queue<Integer> i2 ){
		if(x<n && x>=0 && y>=0 && y<m && a[x][y]==1){
			System.out.println("x:"+x+" y:"+y);
			a[x][y] = -1;
			i1.add(x);i2.add(y);
		}
	}
}
