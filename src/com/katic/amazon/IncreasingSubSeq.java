package com.katic.amazon;

import java.util.Scanner;
import java.util.Stack;

public class IncreasingSubSeq {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Integer> st = new Stack<>();
		while(n>0){
			n--;
		    int size = in.nextInt();
		    int[] a = new int[size];
		    for(int i=0;i<size;i++){
		        a[i] = in.nextInt();
		    }
	        for(int i=0;i<size;i++){
		        if(st.size() == 0){
		            st.push(a[i]);
		        }else{
		            int top = st.peek();
		            while(st.size() > 0 && top > a[i]){
		                top = st.peek();
		                st.pop();
		            }
		            st.push(a[i]);
		        }
		    }
		    int [] r = new int[st.size()];
		    for(int i = st.size()-1;i>0;i--){
		        r[i] = st.pop();
		    }
		    System.out.println();
		    for(int i=0;i<r.length;i++){
		        System.out.print(r[i]+" ");
		    }
		}
	}
}
