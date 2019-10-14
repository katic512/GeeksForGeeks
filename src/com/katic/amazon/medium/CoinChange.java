package com.katic.amazon.medium;

import java.util.Scanner;
/***
 * 
 * @author Katic
 *
 * @source: https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins/0
 */
public class CoinChange {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n>0){
        	n--;
        	int s = in.nextInt();
        	int[] a = new int[s+1];
        	for(int i=1;i<=s;i++){
        		a[i] = in.nextInt();
        	}
        	int m =in.nextInt();
        	int[] r = new int[m+1];
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
