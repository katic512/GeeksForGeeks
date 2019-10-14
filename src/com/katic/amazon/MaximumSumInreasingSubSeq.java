package com.katic.amazon;

import java.util.Scanner;
/**
 * 
 * @author Katic
 *
 * @source: https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0
 * 
 * @Algorithm : https://www.youtube.com/watch?v=99ssGWhLPUE
 */
public class MaximumSumInreasingSubSeq {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int s = in.nextInt();
		    int[] a = new int[s];
		    for(int i=0;i<s;i++){
		        a[i]=in.nextInt();
		    }
		    /****
		     * r[i] maximum sum possible at any that index. Initially set to a[i]
		     * 
		     * 		For getting maximum sub sequence start and end index 
		     * we will have another array index[]. index[i] gives the start index 
		     * and i is end index. Initially set to their own index
		     * 
		     * 
		     */
		    int[] r = new int[s];
		    int[] index = new int[s];
		    for(int i=0;i<s;i++){
		        r[i]=a[i];
		        index[i]=i;
		    }
		    int max = r[0];
		    for(int i=1;i<s;i++){
		        int j=0;
		        while(j<i){
		        	int temp = r[i];
		            if(a[j]<a[i]){//calculation is done
		            	r[i]=Math.max(r[i],r[j]+a[i]);
		            }
		            else {//only comparison is done since a[i] can be greater than sum 
		            	r[i]=Math.max(r[i], a[i]);
		            }
		            index[i] = (temp!=r[i])?j:index[i];// change index if new max found else retain old index
		            j++;
		            if(r[i]>max)max=r[i];// To find overhal max
		        }
		    }
		    System.out.println(max);
		}
	}
}