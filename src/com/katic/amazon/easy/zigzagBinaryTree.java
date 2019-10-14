/**
 * @author Katic
 *
 * @source: 
 */
package com.katic.amazon.easy;
import java.util.HashMap;
//INITIAL CODE
	import java.util.Scanner;
import java.util.Stack;

// code if not verified

public class zigzagBinaryTree {

	

	// A Binary Tree node
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


	class Level_Order_Traversal
	{
		
		
	    // driver function to test the above functions
	    public  void main(String args[])
	    {
			
	        // Input the number of test cases you want to run
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
			//Node root=null;

	        while (t > 0)
	        {
	            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
	            int n = sc.nextInt();

	            Node root=null;

	            while (n > 0)
	            {
	                int n1 = sc.nextInt();
	                int n2 = sc.nextInt();
	                char lr = sc.next().charAt(0);

	                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
	                Node parent = m.get(n1);
	                if (parent == null)
	                {
	                    parent = new Node(n1);
	                    m.put(n1, parent);
	                    if (root == null)
	                        root = parent;
	                }

	                Node child = new Node(n2);
	                if (lr == 'L')
	                    parent.left = child;
	                else
	                    parent.right = child;
	                m.put(n2, child);
	                n--;
	            }
			
	            GfG g = new GfG();
	            g.printSpiral(root);
				System.out.println();
	            t--;
				
	        }
	    }
	}/*
	// A Binary Tree node
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
	*/

	class GfG
	{
	      void printSpiral(Node node) 
	      {
	           // Your code here
	            if(node==null){
	                System.out.print("");return;
	            }
	            Stack<Node> st = new Stack<>();
	            st.push(node);
	            System.out.print(node.data+" ");
	            boolean oddLevel = false;
	            while(st.size()>0){
	                int s = st.size();
	                while(s>0){
	                    s--;
	                    Node t = st.pop();
	                    if(oddLevel){
	                        if(t.right!=null){
	                            System.out.print(t.right.data+" ");
	                            st.push(t.right);}
	                        if(t.left!=null){
	                            System.out.print(t.left.data+" ");
	                            st.push(t.left);
	                        }
	                    }else{
	                        if(t.left!=null){
	                            System.out.print(t.left.data+" ");
	                            st.push(t.left);
	                        }
	                        if(t.right!=null){
	                            System.out.print(t.right.data+" ");
	                            st.push(t.right);
	                        }
	                    }
	                }
	                if(oddLevel){
	                    oddLevel=false;
	                }else{
	                    oddLevel=true;
	                }
	            }
	            
	      }
	}
}


