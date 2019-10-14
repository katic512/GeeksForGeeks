/**
 * @author Katic
 *
 * @source: 
 */
package com.katic.amazon.medium;

import java.util.Arrays;
import java.util.Scanner;

class GFG {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    while(t>0){
	        t--;
	        int s = in.nextInt();
	        int[] a = new int[s];
	        int[] tp = new int[s];
	        for(int i=0;i<s;i++)a[i]=in.nextInt();
	        //tp=LIS(a,tp);
	        int max = tp[0];
	         for(int i=0;i<s;i++){
	        	 Arrays.fill(tp, 1);
	            for(int j = i+1;j<s;j++){
	            	int k = i+1;
	            	while(k<j){
	            		if(a[k]<a[j] && (tp[k]+1)>tp[j]){
	            			tp[j] = tp[k]+1;
	            		}
	            		k++;
	            	}
	            	if(a[j]<a[i] && (tp[j]+1)>tp[i]){
	            		tp[i] = tp[j]+1;
	            	}
	            	if(max<tp[j])max=tp[j];
	            }
	            int k = 0;
	            while(k<i){
            		if(a[k]<a[i] && (tp[k]+1)>tp[i]){
            			tp[i] = tp[k]+1;
            		}
            		k++;
            	}
            	if(max<tp[i])max=tp[i];
	        }
	        System.out.println(max);
	    }
	}
	
	private static int[] LIS(int[] a, int[] tp){
	    for(int i=0;i<a.length;i++){
	            tp[i] = 1;
	            int j=0;
                System.out.println("i:"+i);
               System.out.println("a[i]:"+a[i]);
	            while(j<i){
	             //   System.out.println("j:"+j);
	             //   System.out.println("a[j]:"+a[j]);
	                if(a[j]<a[i] ){
	                 //   System.out.println("tp[j]:"+tp[j]);
	                    tp[i] = tp[j]+1;
	                }
	                j++;
	            }
               System.out.println("tp[i]:"+tp[i]);
	        }
	        return tp;
	}
}
