package com.katic.amazon.easy;

import java.util.Scanner;
/**
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/array-to-bst/0
 */
public class ArrayToBst {

    private static String temp = "";
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    temp = "";
		    int s = in.nextInt();
		    int[] a = new int[s];
		    for(int i=0;i<s;i++){
		        a[i]=in.nextInt();
		    }
		    preorder(a,0,s-1);
		    System.out.println(temp);
		}
	}
	
	private static void preorder(int[] a, int i, int j){
		if(i>j)return;
	    int m = (j+i)/2;
	    temp+=a[m]+" ";
	    System.out.println(a[m]+" i:"+i+" j:"+j+" m:"+m);
	    preorder(a,i,m-1);
	    preorder(a,m+1,j);
	}

}
