/**
 * @author Katic
 *
 * @source: 
 */
package com.katic.amazon.easy;

import com.katic.amazon.Node;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		Node head = new Node(1, new Node(2, new Node(1, null)));
		PalindromeLinkedList pl = new PalindromeLinkedList();
		System.out.println(pl.isPalindrome(head));
	}
	int cl = 0;
	boolean isPalindrome(Node head) 
    {
        Node p1,p2;
        Node root = head;
        int c=1;
        if(head==null || head.next==null){
            return false;
        }else if(head.next.next==null){
            if(head.data==head.next.data)return true;
            return false;
        }
        p1 = head;
        p2 = head.next;
        while(true){
        	if(p2==null){
        		break;
        	}else if(p2.next == null){
        		break;
        	}
            p1 = p1.next;
            p2 = p2.next.next;
            c++;
        }
        Node mid =p1;
        Node midNext = p1.next;
        reverse(midNext);
        System.out.println("c:"+c);
        mid.next = null;
        return compare(head, midNext);
    }    
    
     Node reverse(Node r){
    	 cl++;
       System.out.println("r.data ::"+r.data);
        if(r.next==null)return r;
        Node temp = reverse(r.next);
        temp.next = r;
        r.next=null;
        System.out.println("r.data::"+r.data+" temp :"+temp.data);
        return r;
    }
    
    boolean compare(Node n, Node m){
        while(m!=null){
        System.out.println("n.data:"+n.data+"  m.data:"+m.data);
            if(n.data!=m.data)return false;
            n=n.next;m=m.next;
        }
        return true;
    }

}
