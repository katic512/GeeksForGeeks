package com.katic.amazon;

import java.util.Scanner;
import java.util.Stack;

public class GreaterOnRightSide {

	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
			Stack<Integer> s = new Stack<>();
		    int size = in.nextInt();
		    int[] a = new int[size];
		    for(int i=0;i<size;i++){
		    	a[i] = in.nextInt();
		    }
		    for(int i=0;i<size;i++){
		        if(s.size()>0){
		            while(s.size()>0 && a[s.peek()]<a[i]){
		                a[s.pop()]=a[i];
		                
		            }
		        }
	            s.push(i);
		    }
		    while(s.size()>0){
		                a[s.pop()]=-1;
            }
             for(int i=0;i<size;i++){
                 System.out.print(a[i]+" ");
             }
             System.out.print("\n");
		}
	}
}