package com.katic.amazon;

public class LargestBST {
	private static class Info {
		boolean isBst;
		int min;
		int max;
		int count;

		Info(boolean isBst, int min, int max, int count) {
			this.isBst = isBst;
			this.max = max;
			this.min = min;
			this.count = count;
		}
	}

	private static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String args[]) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		Node temp = root.left;
		temp.left = new Node(40);
		temp.right = new Node(60);
		
		System.out.println(largestBst(root));
	}
	
	public static int largestBst(Node node)
    {
        if(node==null)return 0;
        Info in = postOrderTree(node);
        return in.count;
    }
    
    private static Info postOrderTree(Node root){
        if(root.left==null && root.right==null){
            return new Info(true,root.data,root.data,1);
        }
        Info left=null,right=null;
        if(root.left!=null)
       left = postOrderTree(root.left);
       if(root.right!=null)
       right = postOrderTree(root.right);
       
       if(right!=null && left!=null && right.isBst && left.isBst){
           if(root.data>left.max && root.data<right.min){
               return  new Info(true,left.min,right.max,(right.count+left.count+1));
           }
       }else if(right!=null  && left==null){
           if(right.isBst && root.data<right.min){
               return  new Info(true,root.data,right.max,(right.count+1));
           }else{
               return new Info(false,0,0,right.count);
           }
       }else if(right==null && left!=null){
           if(left.isBst && root.data>left.max){
               return  new Info(true,left.min,root.data,(left.count+1));
           }else{
               return new Info(false,0,0,left.count);
           }
       }
       return  new Info(false,0,0,Math.max(right.count,left.count));
    }
}
