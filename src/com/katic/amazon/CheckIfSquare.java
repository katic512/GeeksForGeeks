package com.katic.amazon;

import java.util.Scanner;

public class CheckIfSquare {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int a1 = in.nextInt();
		    int a2 = in.nextInt();
		    int b1 = in.nextInt();
		    int b2 = in.nextInt();
		    int c1 = in.nextInt();
		    int c2 = in.nextInt();
		    int d1 = in.nextInt();
		    int d2 = in.nextInt();
		    
		    if(Math.abs(a1-d1) == Math.abs(b1-c1) && Math.abs(a2-d2) == Math.abs(b2-c2)){
		    	System.out.println(1);
		    }else{
		    	System.out.println(0);
		    }
		}
	}
}
