package com.katic.amazon.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

public class TreeTopView {

	/*public static void main(String[] args){
		Map<Integer, TreeNode> m = new TreeMap<>();
		Set<Integer> s = new HashSet<>();
	}
	 public void printTopView(TreeNode root)
	    {
	        //add code here.
	        Set<Integer> s = new HashSet<>();
	        Queue<TreeNode> qn = new LinkedList<>();
	        Queue<Integer> qx = new LinkedList<>();
	        qn.add(root);
	        qx.add(0);
	        while(qn.size()>0){
	            int size = qn.size();
	            while(size>0){
	                size--;
	                int x = qx.remove();
	                int tempNode = qn.remove();
	                if(!s.contains(x)){
	                    s.add(x);
	                    System.out.print(root.key+" ");
	                }
	                if(tempNode.left!=null){
	                    qn.add(tempNode.left);
	                    qx.add(x-1);
	                }
	                if(tempNode.right!=null){
	                    qn.add(tempNode.right);
	                    qx.add(x+1);
	                }
	            }
	        }
	    }*/
}
