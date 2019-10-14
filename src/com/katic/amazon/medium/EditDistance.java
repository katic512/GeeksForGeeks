package com.katic.amazon.medium;

import java.util.Scanner;
/*****
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/edit-distance/0
 * 
 * @logic: dynamic programming form a table and getMin(top, left,diagonal) values 
 */
public class EditDistance {

	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int s1 = in.nextInt();
			int s2 = in.nextInt();
			
			char[] st1 =("0"+in.next().trim()).toCharArray();
			char[] st2 =("0"+in.next().trim()).toCharArray();
			int[] r = new int[s1+1];
			for(int i=0;i<=s1;i++){
			    r[i]=i;
			}
			for(int i=1;i<=s2;i++){
				int[] temp = new int[s1+1];
				temp[0]=i;
				for(int j=1;j<=s1;j++){
					int min = Math.min(r[j], temp[j-1]); 
					min = Math.min(r[j-1],min);
					if(st1[j]==st2[i]){
				        temp[j] = r[j-1];
					}else {
						temp[j]=min+1;
					}
				}
				r=temp;
			}
			System.out.println(r[s1]);
		}
	}

}
