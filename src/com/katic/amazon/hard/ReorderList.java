package com.katic.amazon.hard;

import com.katic.amazon.Node;

/**
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/reorder-list/1
 */
public class ReorderList {
	/* Following is the Linked list node structure */
	/*class Node
	{
	    int data;
	    Node next;
	    Node(int d) {data = d; next = null; }
	}*/
		
	Node reorderlist(Node head)
    {
        // Your code here
        Node temp = head;
        int lastIndex = -1;
        int firstIndex = 0;
        Node[] a = new Node[200];
        while(temp!=null){
        	a[++lastIndex]= temp;
            temp=temp.next;
        }
        boolean flag = true;
        Node h = a[firstIndex++];
        Node root = h ;
        while(firstIndex<lastIndex)
        {
            if(flag){
                h.next = a[lastIndex--];
            }else{
                h.next = a[firstIndex++];
            }
            flag = !flag;
            h= h.next;
        }
        h.next = null;
        return root;
    }
}
