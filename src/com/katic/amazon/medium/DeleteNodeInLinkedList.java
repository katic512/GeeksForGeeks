/**
 * @author Katic
 *
 * @source: 
 */
package com.katic.amazon.medium;

import com.katic.amazon.Node;

public class DeleteNodeInLinkedList {

	public static void main(String[] args) {
		DeleteNodeInLinkedList dl = new DeleteNodeInLinkedList();
		Node head = new Node(1, new Node(2,new Node(2,new Node(3,new Node(2,new Node(3,null))))));
		dl.deleteAllOccurances(head, 2);
	}
	Node deleteAllOccurances(Node head, int x)
    {
        Node prev = null;
        Node root = head;
        if(head.data==x){
            while(head.data==x){
                head = head.next;
            }
            root = head;
        }
        prev = head;
        while(head!=null){
            if(head.data==x){
                prev.next = head.next;
                head = head.next;
                continue;
            }
            prev = head;
            head = head.next;
        }
        return root;
    }
}
