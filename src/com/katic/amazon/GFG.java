package com.katic.amazon;

import java.util.Scanner;

class GFG {
	public static void main (String[] args) {
		Scanner in  =  new Scanner(System.in);
		int n = in.nextInt();
		while(n>0){
		    n--;
		    int v = in.nextInt();
		    if(v<4){
		        System.out.println("0");
		    }else{
		    	boolean flag = false;
			    int i=0;
			    for(i=v/2;i>1;i--){
			        if(checkPower(v,i)) {
			        	//System.out.println(i);
			            flag =true;break;
			        }
			    }
			    if(flag){
			        System.out.println("1");
			    }else{
			        System.out.println("0");
			    }	
		    }
		}
	}
	
	private static boolean checkPower(int v, int d){
		
	    if(v == d) return true;
	    if(v < d){
	        return false;
	    } else if(v%d != 0){
	    	return false;
	    }
	    return checkPower(v/d,d);
	}
}