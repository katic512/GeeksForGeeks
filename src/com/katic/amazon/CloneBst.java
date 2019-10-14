package com.katic.amazon;

import java.util.HashMap;
import java.util.Map;

public class CloneBst {

	static class Tree{
		int data;
		Tree left,right,random;
		Tree(int d){
			data=d;
			left=null;
			right=null;
			random=null;
		}
	} 
	
	public static void main(String [] a){
		Tree root = new Tree(6);
		root.left = new Tree(3);
		root.right= new Tree(8);
		Tree temp = root.left;
		temp.left = new Tree(1);
		temp.right = new Tree(5);
		temp.left.random = temp;
		temp.right.random = root;
		cloneTree(root);
	}
	
	 static Map<Integer, Tree> map;
	    public static Tree cloneTree(Tree tree){
	       // add code here.
	       Tree myTree = null;
	        if(tree==null){
	             return null;
	         }
	       map = new HashMap<>();
	       myTree = myClone(tree);
	       cloneRandom(tree,myTree);
	       return myTree;
	     }
	    
	     
	     private static Tree myClone(Tree tree){
	    	 if(tree==null) return null;
	         Tree myTree= new Tree(tree.data);
	         map.put(myTree.data,myTree);
	         myTree.left=myClone(tree.left);
	         myTree.right=myClone(tree.right);
	         return myTree;
	     }
	      
	    private static void cloneRandom(Tree tree, Tree myTree){
	        if(myTree==null)return;
	        if(tree.random!=null)
	        myTree.random = map.get(tree.random.data);
	        cloneRandom(tree.left,myTree.left);
	        cloneRandom(tree.right,myTree.right);
	    }
}
