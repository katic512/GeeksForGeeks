package com.katic.amazon.easy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
/***
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/next-larger-element/0
 */
public class NextLargestArrayElements {
		public static void main (String[] args) {
			//code
			Scanner in = new Scanner(System.in);
			int t = in.nextInt();
			while(t>0){
			    t--;
			    int s = in.nextInt();
			    int[] a = new int[s];
			    for(int i=0;i<s;i++){
			        a[i] = in.nextInt();
			    }
			    int[] r = new int[s];
			    Arrays.fill(r,-1);
			    Stack<Integer> st = new Stack<>();
			    for(int i=0;i<s;i++){
			        if(st.size()>0){
			            while(st.size()>0 && a[i]>a[st.peek()] ){
			                int temp = st.peek();
			                r[temp] = a[i];
			                st.pop();
			            }
			        }
		            st.push(i);
			    }
			    String str = null;
			    for(int i=0;i<s;i++){
			    	if(i==0){
			    		str = String.valueOf(r[i]);
			    	}else{
			    		str+=" "+r[i];
			    	}
			    }
			    System.out.println(str);
			}
		}
	}