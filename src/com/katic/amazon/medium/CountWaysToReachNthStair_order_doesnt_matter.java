/**
 * @author Katic
 *
 * @source: https://practice.geeksforgeeks.org/problems/count-ways-to-nth-stairorder-does-not-matter/0
 * 
 * @logic: similar to coin ways
 */
package com.katic.amazon.medium;

import java.util.Scanner;

public class CountWaysToReachNthStair_order_doesnt_matter {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n>0){
        	n--;
        	int[] a = {0,1,2};
        	int s = 2;
        	int m =in.nextInt();
        	int[] r = new int[m+1];
        	//Arrays.fill(r, 1);
        	for(int i=1;i<=s;i++){
        		int[] temp = new int[m+1];
        		temp[0]=1;
        		for(int k = 1;k<=m;k++){
        			if(a[i]>k){
        				temp[k] = r[k];
        			}else{
        				if(temp[k-a[i]]!=0){
        					temp[k]=r[k]+Math.max(temp[k-a[i]], 1);
        				}else{
        					temp[k] = r[k];
        				}
        			}
        		}
        		r=temp;
        	}
        	System.out.println(r[m]);
        }
    }
}