/**
 * @author Katic
 *
 * @source: http://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1
 */
package com.katic.amazon.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinaryTreeFromPostorderAndInorder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0){
			t--;
			int s = sc.nextInt();
			int[] in = new int[s];
			int[] post = new int[s];
			for(int i=0;i<s;i++){
				in[i] = sc.nextInt();
			}
			for(int i=0;i<s;i++){
				post[i] = sc.nextInt();
			}
			BinaryTreeFromPostorderAndInorder br = new BinaryTreeFromPostorderAndInorder();
			br.buildTree(in, post, s);
		}
	}

	Map<Integer, Node> m = new HashMap<>();

	Node buildTree(int in[], int post[], int n)
	{
		m = new HashMap<>();
		recurse(in, post,0,0,n-1,n-1,false,null);
		printPreOder(m.get(post[n-1]));
		return m.get(post[n-1]);
	}

	private void printPreOder(Node node) {
		if(node==null)return;
		System.out.print (node.data+" ");
		printPreOder(node.left);
		printPreOder(node.right);
	}

	//params inorderArray, postorderArray, inorderStartIndex,postorderStartIndex, inorderEndIndex,postorderEndIndex,isPrevChild, child[if(prevChild)]
	private Node recurse(int[] in, int[] post, int i,int j, int ni,int nj, boolean isPrevChild,Node child) {
		if(i>ni || j>nj)return child;
		if(in[i]!=post[j] || (in[i] == post[j] && isPrevChild)){
			Node temp = new Node(in[i]);
			int index = -1;
			for(int k = j ;k<=nj;k++){
				if(post[k]==in[i]){
					index = k;
					break;
				}
			}
			int diff = index-j;
			m.put(in[i], temp);
			if(isPrevChild)temp.left = child;
			int iLimit = (i+diff>ni)?ni:i+diff;
			temp.right = recurse(in, post, i+1, j, iLimit, index-1, false, null);
			return recurse(in, post, index+1, index+1, ni, nj, true, temp);
		}else{
			Node temp = new Node(in[i]);
			m.put(in[i], temp);
			return recurse(in, post, i+1, j+1, ni, nj, true, temp);
		}
	}
	

}
