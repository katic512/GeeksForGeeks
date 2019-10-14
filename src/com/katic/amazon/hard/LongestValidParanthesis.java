package com.katic.amazon.hard;

import java.util.Scanner;
/***
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/longest-valid-parentheses/0
 * 
 * @logic: assign (=1 and )=-1 in array. Now parse the array every time -1 is encountered 
 * parse reverse if -1 encountered break since its invalid if 1 encountered
 * mark both -1 and 1 location as 0 meaning found. Now in between if 0 encountered skip visit previous
 */
public class LongestValidParanthesis {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			char[] a = in.next().trim().toCharArray();
			int[] r = new int[a.length];
			for(int i=0;i<a.length;i++){
				r[i] = (a[i]==')')?-1:1;
			}
			for(int i=1;i<r.length;i++){
				if(r[i]==-1){
					int j=i-1;
					while(j>=0){
						if(r[j] == 0) {
							j--;
							continue;
							}
						if(r[j] == -1) break;
						r[i]=r[j]=0;
						break;
					}
				}
			}
			int c =0, max =0;
			for(int i=0;i<r.length;i++){
				//System.out.print(r[i]+" ");
				if(r[i]==0){
					c++;
				}else{
					if(max<c)max=c;
					c=0;
				}
			}

			if(max<c)max=c;
			System.out.println(max);
		}
	}
}
