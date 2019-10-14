package com.katic.amazon.hard;

import java.util.Scanner;
/***
 * 
 * @author Katic
 *
 * @source: https://www.geeksforgeeks.org/arrange-given-numbers-form-biggest-number-set-2/
 * 
 * @logic: normal sorting but with custom compare condition
 */
public class LargestNumberFormedFromArray {

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
		    String tempSt = "";
		    for(int i=0;i<s-1;i++){
		    	int maxIndex=i;
		    	for(int j=i+1;j<s;j++){
		    		if(firstNumberbig(a[j],a[maxIndex])){
		    			maxIndex=j;
		    		}
		    	}
		    	if(i!=maxIndex){
			    	int temp = a[i];
			    	a[i] = a[maxIndex];
			    	a[maxIndex] = temp;
		    	}
		    }
		    for(int i=0;i<s;i++){
		    	tempSt+=a[i];
		    }
		    System.out.println(tempSt);
		}
	}

	private static boolean firstNumberbig(int i, int j) {
		String s1=String.valueOf(i)+String.valueOf(j);
		String s2 =String.valueOf(j)+String.valueOf(i);
		if(Integer.valueOf(s1)>Integer.valueOf(s2))return true;
			
		return false;
	}
}
