package com.katic.amazon.medium;

import java.util.Scanner;
/***
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/longest-common-subsequence/0
 */
public class LongestCommonSubSequence {
	public static void main(String[] ar){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int s1 = in.nextInt()+1;
			int s2 = in.nextInt()+1;
			char[] st1 = ("0"+in.next().trim()).toCharArray();
			char[] st2 = ("0"+in.next().trim()).toCharArray();
			int[] r = new int[s1];
			for(int i=1;i<s2;i++){
				int[] temp = new int[s1];
				for(int j=1;j<s1;j++){
					int max = Math.max(Math.max(r[j-1],temp[j-1]),r[j]);
					if(st1[j]==st2[i]){
						temp[j]=max+1;
					}else{
						temp[j]=max;
					}
				}
				r=temp;
			}
			System.out.println(r[s1-1]);
		}
	}
}
