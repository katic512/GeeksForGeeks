/**
 * @author Katic
 *
 * @source: http://practice.geeksforgeeks.org/problems/preorder-traversal-and-bst/0
 */
package com.katic.amazon.medium;

import java.util.Scanner;
import java.util.Stack;

public class PreOrderAndBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        outer:while(t>0){
            t--;
            int size = in.nextInt();
            int[] a = new int[size];
            Stack<Integer> s = new Stack<>();
            for(int i=0;i<size;i++){
                a[i] = in.nextInt();
            }
            int root = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
            	if(s.size()>0){
            		if(s.peek()<a[i]){
            			System.out.println(0);
            			continue outer;
            		}
            		while(!s.isEmpty() && s.peek()<a[i]){
            			root = s.pop();
            		}
            		s.push(a[i]);
            	}else{
            		s.push(a[i]);
            	}
            }
            System.out.println(1);
        }
	}

}
