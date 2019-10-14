package com.katic.amazon.medium;

import java.util.Scanner;


/**
 * @author Katic
 *
 * @source: http://practice.geeksforgeeks.org/problems/longest-arithmetic-progression/0
 */
public class LongestArithmeticProgression {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int s = in.nextInt();
		    int[] a = new int[s];
		    int[][] d = new int[s][s];
		    int[][] l = new int[s][s];
		    for(int i=0;i<s;i++){
		    	a[i] = in.nextInt();
		    }
		    if(s<3){
		    	System.out.println(s);
		    	continue;
		    }
		    int maxLen= 0 ;
		    for(int i=1;i<s;i++){
		    	int j = i-1;
		    	while(j>=0){
		    		int diff = a[i]-a[j];
		    		int len = 1;
		    		for(int k = 0; k<j;k++){
		    			if(d[j][k] == diff){
		    				len+=l[j][k];
		    				break;
		    			}
		    		}
		    		d[i][j] = diff;
		    		l[i][j] = len;
		    		maxLen = Math.max(len, maxLen);
		    		j--;
		    	}
		    }
		    System.out.println(maxLen+1);
		}
	}
}
