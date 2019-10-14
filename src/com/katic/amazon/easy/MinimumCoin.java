package com.katic.amazon.easy;

import java.util.Scanner;
/***
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins/0
 */
public class MinimumCoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        while(n>0){
	        	n--;
	        	int s = in.nextInt();
	        	int m =in.nextInt();
	        	int[] a = new int[s+1];
	        	for(int i=1;i<=s;i++){
	        		a[i] = in.nextInt();
	        	}
	        	int[] r = new int[m+1];
	        	//Arrays.fill(r, Integer.MAX_VALUE);
	        	for(int i=1;i<=s;i++){
	        		int[] temp = new int[m+1];
	        		//temp[0]=1;
	        		for(int k = 1;k<=m;k++){
	        			if(a[i]>k){
	        				temp[k] = r[k];
	        			}else{
	        				if(k%a[i]==0){
	        					temp[k] = k/a[i];
	        				}else if(temp[k-a[i]]!=0){
	        					temp[k]=Math.min(r[k], (1+temp[k-a[i]]));
	        				}else{
	        					temp[k] = r[k];
	        				}
	        			}
	        		}
	        		r=temp;
	        	}
	        	if(r[m]==0){
	        		r[m]=-1;
	        	}
	        	System.out.println(r[m]);
	        }
	}

}
