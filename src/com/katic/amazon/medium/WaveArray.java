/**
 * @author Katic
 *
 * @source: https://practice.geeksforgeeks.org/problems/wave-array/0
 */
package com.katic.amazon.medium;

import java.util.Arrays;
import java.util.Scanner;

public class WaveArray {
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
		    Arrays.sort(a);
		    int i=0;
		    String tempSt="";
		    while(i<s){
		       // System.out.println(i);
		        if(i+1<s){
    		        int temp = a[i];
    		        a[i]=a[i+1];
    		        a[i+1]=temp;
    		        tempSt+=a[i]+" "+a[i+1]+" ";
		        }else{
		            tempSt+=a[i]+" ";
		        }
		        i+=2;
		    }
		    System.out.println(tempSt);
		}
	}
	    

}
