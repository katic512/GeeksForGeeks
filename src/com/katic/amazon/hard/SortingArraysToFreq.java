package com.katic.amazon.hard;

import java.util.LinkedList;
import java.util.Scanner;
/***
 * 
 * @author Katic
 *
 * @source:https://www.geeksforgeeks.org/sort-elements-by-frequency/
 * 
 * @logic: Step 1 define array[maxNumber] and add corresponding position
 * 		step 2 define array of linked list and loop count array 0 to n, there by adding values to count index
 * 		e.g for 2 and 4 occurring 3 times will be like
 * 		[3]= 4->2->null;
 * 		step 3 now loop linked list array bottom to top and print values 
 */
public class SortingArraysToFreq {

	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int s = in.nextInt();
		    int[] a = new int[s+1];
		    int max = -1;
		    for(int i = 1; i<=s;i++){
		        a[i] = in.nextInt();
		        if(a[i]>max)max=a[i];
		    }
		    int[] times = new int[max+1];
		    for(int i=1; i<=s; i++){
		        times[a[i]]++;
		    }
		    @SuppressWarnings("unchecked")
			LinkedList<Integer>[] f = new LinkedList[max+1];
		    for(int i=1; i<=max;i++){
		        if(times[i]!=0){
		            if(f[times[i]] == null){
		                f[times[i]] = new LinkedList<Integer>();
		            }
	                f[times[i]].add(i);
		        }
		    }
		    for(int j=max; j>0 ;j --){
                if(f[j]!=null){
                    while(f[j].size()>0){
                        int v = f[j].remove();
                        int k = j;
                        while(k>0){
                            k--;
                            System.out.print(v+" ");
                        }
                    }
                }		        
		    }
		    System.out.print("\n");
		}
	}
}
