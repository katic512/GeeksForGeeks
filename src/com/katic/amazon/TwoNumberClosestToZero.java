package com.katic.amazon;

import java.util.Arrays;
import java.util.Scanner;
/***
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/two-numbers-with-sum-closest-to-zero/0
 */
public class TwoNumberClosestToZero {
	public static void main (String[] args) {
    	Scanner in = new Scanner(System.in);
    	int t = in.nextInt();
    	while(t>0){
    	    t--;
    	    int s = in.nextInt();
    	    int[] a = new int[s];
    	    for(int i=0;i<s;i++){
		        a[i]=in.nextInt();
		    }
    	    int l=0;
    	    int k=0;
    	    int max = Integer.MAX_VALUE;
    	    Arrays.sort(a);
    	    int i=0;
    	    int j=s-1;
    	    while(i<j){
    	        int sum = a[i]+a[j];
    	        if(Math.abs(sum)<Math.abs(max)){
    	            max=sum;
    	            l=i;
    	            k=j;
    	            if(max==0)break;
    	        }
    	        if(sum<0){
    	            i++;
    	        }else{
    	            j--;
    	        }
    	    }
    	     if(a[l]>a[k]){
    	        System.out.println(a[k]+" "+a[l]);
    	    }else{
        	    System.out.println(a[l]+" "+a[k]);    
    	    }
	    }
	}
}
