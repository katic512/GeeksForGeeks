/**
 * @author Katic
 *
 * @source: 
 */
package com.katic.amazon.medium;

public class CheckIfBst {
	class Node
	{
	    int data;
	    Node left, right;

	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	} 
	int isBST(Node root)  
    {
        // Your code here
        if(root==null)return 1;
        return checkIfBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    int checkIfBst(Node node, int min, int max){
        
           // System.out.println("node.data:"+node.data + " min&max:"+min+":"+max);
        if(node.data<=min || node.data>=max){
            //System.out.println("inside node.data:"+node.data + " min&max:"+min+":"+max);
            return 0;
            
        }
        int left=1,right=1;
        if(node.left!=null){
            left = checkIfBst(node.left, min, node.data);
        }
        if(node.right!=null){
            right = checkIfBst(node.right, node.data, max);
        }
        if(left==0 || right == 0){
            return 0;
        }
        return 1;
    }
}
