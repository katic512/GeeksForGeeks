package com.katic.amazon.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * 
 * @author Katic
 *
 * @source: https://www.geeksforgeeks.org/check-if-two-trees-are-mirror/
 * 
 */
public class IsMirrorTree {

    static class Node{
        int d;
        Node left, right;
        Node(int n){
            this.d = n;
        }
        Node(Node a, Node b){
            this.left = a;
            this.right = b;
        }
        Node(int n,Node a, Node b){
            this.d = n;
            this.left = a;
            this.right = b;
        }
    }
    
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int n = in.nextInt();
		    int m = in.nextInt();
		    int[] a = new int[2*m];
		    Map<Integer, Node> aMap = new HashMap<>();
		    Map<Integer, Node> bMap = new HashMap<>();
		    for(int i=0;i<2*m;i++){
	            a[i] = in.nextInt();
	            if(!aMap.containsKey(a[i])){
	                aMap.put(a[i], new Node(a[i]));
	            }
		    }
		    int[] b = new int[2*m];
		    for(int i=0;i<2*m;i++){
	            b[i] = in.nextInt();
	            if(!bMap.containsKey(b[i])){
	                bMap.put(b[i], new Node(b[i]));
	            }
		    }
		    Node aTree = createTree(a, aMap);
		    Node bTree = createTree(b, bMap);
		    if(isMirror(aTree, bTree)){
		        System.out.println(1);
		    }else{
		        System.out.println(0);
		    }
		}
	}
	
	private static Node createTree(int[] a,Map<Integer, Node> aMap){
	    int i = 0;
	    while(i+1<a.length){
	        int s = a[i++];
	        int d = a[i++];
	        Node sNode = aMap.get(s);
	        Node dNode  = aMap.get(d);
	        if(sNode.left ==null){
	            sNode.left = dNode;
	        }else{
	            sNode.right = dNode;
	        }
	    }
	    return aMap.get(a[0]);
	}
	
	private static boolean isMirror(Node a, Node b){
		/*
	    if(a!=null && b==null || a==null && b!=null)return false;
	    if(a==null && b==null) return true;
	    if(a.left.d != b.right.d)return false;
	    if(isMirror(a.left, b.right)){
	        if(isMirror(a.right, b.left)){
	            return true;
	        }
	    }
	    return false;*/
		if(a!=null && b==null || a==null && b!=null)return false;
	    if(a==null && b==null) return true;
		if(checkSubTree(a, b)){
			if(isMirror(a.left, b.left)){
				if(isMirror(a.right, b.right)){
					return true;
				}
			}
			return false;
		}else{
			return false;
		}
	}
	
	private static boolean checkSubTree(Node a, Node b){
		if(a.left!=null && b.right==null || a.left==null && b.right!=null)return false;
		if(a.left!=null && a.left.d != b.right.d) return false;
		if(a.right!=null && a.right.d != b.left.d) return false;
		return true;
	}
}

