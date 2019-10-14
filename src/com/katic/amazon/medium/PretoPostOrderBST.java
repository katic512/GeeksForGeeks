package com.katic.amazon.medium;

import java.util.Scanner;
/*****
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/preorder-to-postorder/0
 */
public class PretoPostOrderBST {
	static class Node{
        Node left;
        Node right;
        int n ;
        
        Node(int n, Node l, Node r){
            this.left=l;
            this.right=r;
            this.n=n;
        }
    }
    private static Node root=null;
    private static int pe=0,po=0;
	public static void main (String[] args) {
		//code
	    Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    outer:while(t>0){
	        t--;
	        int s = in.nextInt();
	        int[] a = new int[s];
	        int[] preOrder = new int[s];
	        int[] postOrder = new int[s];
	        for(int i=0;i<s;i++){
	            a[i]=in.nextInt();
	            if(i==0){
	                root = new Node(a[i],null,null);
	            }else{
	                insert(root,a[i]);
	            }
	        }
	        pe=0;po=0;
	        generatePre_PostOrder(preOrder,postOrder,root);
	        String temp ="";
	        for(int i=0;i<s;i++){
	            System.out.print(preOrder[i]+" ");
	            if(preOrder[i]!=a[i]){
	                System.out.println("No");continue outer;
	            }
	            temp+=postOrder[i]+" ";
	        }
	        System.out.println(temp);
	    }
	}
	
	private static void insert(Node root, int n){
	    if(root.n>n){
	        if(root.left==null){
	            root.left=new Node(n,null,null);
	            return;
	        }else{
	            insert(root.left,n);
	        }
	    }else{
	        if(root.right==null){
	            root.right=new Node(n,null,null);
	            return;
	        }else{
	            insert(root.right,n);
	        }
	    }
	}
	
	private static void generatePre_PostOrder(int[] pre, int[] post , Node root){
	    if(root==null)return;
	    pre[pe++]=root.n;
	    generatePre_PostOrder(pre, post, root.left);
	    generatePre_PostOrder(pre, post, root.right);
	    post[po++]=root.n;
	}
}