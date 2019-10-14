/**
 * @author Katic
 *
 * @source: 
 */
package com.katic.amazon.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

import com.katic.amazon.TreeNode;

public class DiagonalTraversalBinaryTree {

	public static void main(String[] args) {
		DiagonalTraversalBinaryTree dtb = new DiagonalTraversalBinaryTree();
		dtb.diagonalPrint();
	}
	
	Map<Integer, TreeNode> m ;
	Map<Integer, Queue<Integer>> mq ;
	public void diagonalPrint()
    {
		m = new HashMap<>();
		mq = new TreeMap<>();
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine().trim());
		while(t>0){
			t--;
			int n = Integer.parseInt(in.nextLine().trim());
			String[] c =in.nextLine().split(" ");
			int rootNum = Integer.parseInt(c[0]+"");
			for(int i=0;i<c.length;i++){
					if(c[i].equals("R")|| c[i].equals("L")){
						TreeNode prevNode = m.get( Integer.parseInt(c[i-1]));
						TreeNode ppRevNode = m.get( Integer.parseInt(c[i-2]));
						if(c[i].equals("R")){
							ppRevNode.right = prevNode;
						}else{
							ppRevNode.left = prevNode;
						}
					}else{
						int num =  Integer.parseInt(c[i]);
						if(!m.containsKey(num)){
							TreeNode root = new TreeNode(num);
							m.put(num, root);
						}
					}
				}
			TreeNode rootNode = m.get(rootNum);
			diagonalTraverse(rootNode,0);
			for(Integer d:mq.keySet()){
				Queue<Integer> q = mq.get(d);
				while(q.size()>0){
					System.out.print(q.remove()+" ");
				}
			}
		}
    }
	private void diagonalTraverse(TreeNode rootNode,int d) {
		if(rootNode==null)return;
		if(mq.containsKey(d)){
			Queue<Integer> q = mq.get(d);
			q.add(rootNode.data);
		}else{
			Queue<Integer> q = new LinkedList<>();
			q.add(rootNode.data);
			mq.put(d, q);
		}
		diagonalTraverse(rootNode.left, d+1);
		diagonalTraverse(rootNode.right, d);
	}
	
}
