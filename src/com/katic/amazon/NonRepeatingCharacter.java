package com.katic.amazon;

import java.util.Scanner;

public class NonRepeatingCharacter {
	public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int size = in.nextInt();
		    char arr[] = in.next().trim().toCharArray();
		    int[] count = new int[27];
		    boolean found = false;
		    for(int i=0;i<size;i++) {
		    	count[((int)arr[i])-96]++; 
		    }
		    for(int i=0;i<arr.length;i++) {
		    	if(count[((int)arr[i])-96] == 1) {
		    		System.out.println(arr[i]);
		    		found = true;
		    		break;
		    	}
		    }
		    if(!found) {
		    	System.out.println(-1);
		    }
		}
	}
}
