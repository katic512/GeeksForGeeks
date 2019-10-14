package com.katic.amazon;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PrintLCSsquence {
	public static void main(String[] arg){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			char[] a = ("0"+in.next()).trim().toCharArray();
			char[] b = ("0"+in.next()).trim().toCharArray();
			Set<String> out = new TreeSet<>();
			int[][] e = new int[b.length][a.length];
			int[] r = new int[a.length];
			//Arrays.fill(r, new E(0,new ArrayList<>()));
			e[0] = r;
			for(int i = 1; i<b.length; i++){
				int[] temp = new int[a.length];
				temp[0] = 0;
				for(int j=1; j<a.length; j++){
					if(b[i] == a[j]){
						temp[j] = r[j-1]+1;
					}else{
						temp[j] = Math.max(temp[j-1], r[j]);
					}
				}
				r = temp;
				e[i] = temp;
			}
			for(int i=0; i<b.length; i++){
				for(int j=0; j<a.length; j++){
					if(i==0){
						System.out.print(a[j] +" ");
					}else{
						if(j==0){
							System.out.print(b[i] +" ");
						}else{
							System.out.print(e[i][j]+" ");
						}
					}
				}
				System.out.println();
			}
			for(String stx : out){
				System.out.print(stx+" ");
			}
			System.out.println();
		}
	}
}
