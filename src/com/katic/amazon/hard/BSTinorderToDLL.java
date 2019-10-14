/**
 * @author Katic
 *
 * @source: 
 */
package com.katic.amazon.hard;

public class BSTinorderToDLL {

	class Node{
		Node left;
		Node right;
		String s;
		
		Node(){}
		Node(Node left, Node right, String s){
			this.left = left;
			this.right = right;
			this.s = s;
		}
	}
	private Node root;
	public static void main(String[] args) {
		BSTinorderToDLL b = new BSTinorderToDLL();
		b.initialize();
		b.BToDLL(b.root);
	}
	private void initialize() {
		Node a = new Node(null, null,"a");
		Node b = new Node(null, null,"b");
		Node c = new Node(a, b,"c");
		Node i = new Node(null, null,"i");
		Node j = new Node(null, null,"j");
		Node h = new Node(i, j,"h");
		Node g = new Node(null, null,"g");
		Node f = new Node(null, g,"f");
		Node e = new Node(f, h,"e");
		root = new Node(c, e,"d");
		
	}
	Node head;
	Node BToDLL(Node root)
	{
		head = null;
		InorderToDLL(root,null,false);
		return head;
	}

	private Node InorderToDLL(Node root, Node prev,boolean leftLeaf){
		if(root==null)return null;
		root.left=InorderToDLL(root.left, root,true);
		if(head==null)head = root;
		System.out.print(root.s+" ");
		root.right = InorderToDLL(root.right, root,false);
		return root;
	}
}
