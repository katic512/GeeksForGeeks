/**
 * @author Katic
 *
 * @source: http://practice.geeksforgeeks.org/problems/inorder-traversal-and-bst/0
 */
package com.katic.amazon.easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InorderAndBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0){
            t--;
            int size = in.nextInt();
            int[] a = new int[size];
            Set<Integer> s = new HashSet<>();
            boolean flag = true;
            for(int i=0;i<size;i++){
                a[i] = in.nextInt();
                if(i==0){
                	s.add(a[i]);
                }else{
                	if(flag){
                		if(a[i]<a[i-1]){
                			flag = false;continue;
                		}
                		if(s.contains(a[i]))flag = false;
                	}
                }
            }
            if(flag){
            	System.out.println(1);
            }else{
            	System.out.println(0);
            }
        }
	}

}
