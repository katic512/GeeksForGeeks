package com.katic.amazon.medium;

import java.util.Scanner;

public class MaxSumofLengthIncreasingSubSeq {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int s = in.nextInt();
		    int k = in.nextInt();
		    int[] a = new int[s];

		    int[] sum = new int[s];
		    int[]  l = new int[s];
		    int[] sourc = new int[s];
		    for(int i=0;i<s;i++){
		        a[i]=in.nextInt();
		        sum[i] = a[i];
		        l[i] =1;
		        sourc[i] = i;
		    }
		    int maxl = 0;
		    int maxSum = 0;
		    for(int i=1;i<s;i++){
		        int j=0;
		        while(j<i){
		            if(a[j]<a[i]){
		            	if(sum[i]<sum[j]+a[i] && l[j]<k){
		            		sourc[i] = j;
		            		sum[i] = sum[j]+a[i];
		            		l[i] = l[j]+1;
		            	}
		            	
		            }
		            j++;
		            	if(l[i] == k && sum[i]>maxSum){
		            		maxl = i;
		            		maxSum=sum[maxl];
		            }
		        }
		    }
		    System.out.println(maxSum);
		   /* if(l[maxl]<k){
		    	System.out.println(-1);
		    }else{
		    	if(l[maxl] == k){
		    		maxSum = Math.max(maxSum, sum[maxl]);
		    		System.out.println(maxSum);
		    	}else{
			    	int temp = maxl;
			    	while(k>0){
			    		k--;
			    		temp = sourc[temp];
			    	}
			    	maxSum = Math.max(maxSum, sum[maxl]-sum[temp]);
			    	System.out.println(maxSum);
		    	}
		    }*/
		}
	}
}
