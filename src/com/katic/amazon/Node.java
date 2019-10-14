package com.katic.amazon;

public class Node {
	public  int key;
	 public int data;
	    public Node left, right;
	    public Node next, bottom;
	   Node(int item)    {
	        key = item;
	        left = right = null;
	    }
	   public Node(int data, Node next){
		   this.data = data;
		   this.next = next;
	   }
}
