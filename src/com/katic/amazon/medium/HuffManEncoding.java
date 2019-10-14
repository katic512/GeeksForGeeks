/**
 * @author Katic
 *
 * @source: 
 */
package com.katic.amazon.medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
/***
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/huffman-encoding/0
 */
public class HuffManEncoding {

	static class Node{
		int n;
		char c;
		Node left;
		Node right;

		Node(int n, char c){
			this.n = n;
			this.c = c;
			this.left = null;
			this.right = null;
		}
		
		Node(){}
	}

	public static void main (String[] args) {
		Scanner in =  new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			String s = in.next();
			int [] a = new int[s.length()];
			for(int i=0;i<a.length;i++){
				a[i] = in.nextInt();
			}
			PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<HuffManEncoding.Node>(){
				@Override
				public int compare(Node arg0, Node arg1) {
					if(arg0.n<arg1.n)return -1;
					return 1;
				}
			});

			for(int i=0;i<a.length;i++){
				pq.add(new Node(a[i],s.charAt(i)));
			}
			while(pq.size()>1){
				Node one = pq.poll();
				Node two = pq.poll();
				Node temp = new Node();
				temp.left = one;
				temp.right = two;	
				temp.n = one.n+two.n;
				pq.add(temp);
			}

			traverse(pq.peek(), "");
		}
	}

	private static void traverse(Node peek, String st) {
		if(peek.left==null && peek.right==null){
			System.out.print(st+" ");
			return;
		}
		if(peek.left!=null)
			traverse(peek.left,st+"0");

		if(peek.right!=null){
			traverse(peek.right,st+"1");

		}
		
	}
}