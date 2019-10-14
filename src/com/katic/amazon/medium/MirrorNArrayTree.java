/**
 * @author Katic
 *
 * @source: http://practice.geeksforgeeks.org/problems/check-mirror-in-n-ary-tree/0
 */
package com.katic.amazon.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MirrorNArrayTree {

	static class Node{
		int p;
		int c;
		Node(int p, int c){
			this.c =c; this.p = p;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int n = in.nextInt();
			int m = in.nextInt();
			int[] a = new int[2*m];
			int[] b = new int[2*m];
			for(int i = 0;i<2*m;i++){
				a[i] = in.nextInt();
			}
			for(int i = 0;i<2*m;i++){
				b[i] = in.nextInt();
			}
			Stack<Node> s1 = new Stack<>();
			Queue<Node> s2 = new LinkedList<>();
			Queue<Integer> q = new LinkedList<>();
			boolean flag = true;
			outer :for(int i = 0;i<m*2-1;i++){
				if(!q.isEmpty()){
					boolean found = false;
					for(Integer num:q){
						if(num==a[i]){
							found = true;
							break;
						}					
					}
					if(found){
						if(!verify(s1,s2,q)){
							flag = false;
							break outer;
						}
						
					}
					addValues(s1,s2,q,a,b,i);
					i++;

				}else{
					addValues(s1,s2,q,a,b,i);
					i++;
				}
			}
			if(!q.isEmpty()){
				flag = verify(s1,s2,q);
			}
			if(flag){
				System.out.println(1);
			}else{
				System.out.println(0);
			}
		}
	}
	private static void addValues(Stack<Node> s1, Queue<Node> s2, Queue<Integer> q, int[] a, int[] b, int i) {
		s1.push(new Node(a[i],a[i+1]));
		s2.add(new Node(b[i],b[i+1]));
		q.add(a[i+1]);
	}
	private static boolean verify(Stack<Node> s1, Queue<Node> s2, Queue<Integer> q) {
		while(!s1.isEmpty() && !s2.isEmpty()){
			Node sn1 = s1.pop();
			Node sn2 = s2.remove();
			if(sn1.p!=sn2.p || sn1.c!=sn2.c){
				return false;
			}
			q.remove(sn1.p);
		}
		if(s1.size()>0 || s2.size()>0){
			return false;
		}
		return true;
	}


}
