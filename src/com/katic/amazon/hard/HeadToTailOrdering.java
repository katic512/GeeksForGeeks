/**
 * @author Katic
 *
 * @source: 
 */
package com.katic.amazon.hard;

import java.util.ArrayList;
import java.util.Scanner;
/*******
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/head-to-tail-ordering/0
 */
public class HeadToTailOrdering {

	static class Node {
		String s;
		ArrayList<Integer> p;
		boolean visited = false;

		Node(String s) {
			this.s = s;
			this.p = new ArrayList<>();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		outer: while (t > 0) {
			t--;
			int n = in.nextInt();
			ArrayList<Node> nodes = new ArrayList<>();
			int[] nodeIds = new int[n];
			for (int i = 0; i < n; i++) {
				String temp = in.next();
				//System.out.println("No:"+i+" :: "+temp);
				nodes.add(new Node(temp));
			}
			//below logic to identify the starting point, if a node is not a child of other then i consider it as starting point
			//but there shouldnt be more than one starting point
			
			for (int i = 0; i < nodes.size(); i++) {
				for (int j = 0; j < nodes.size(); j++) {
					if (i != j) {
						String is = nodes.get(i).s;

						String js = nodes.get(j).s;
						if (is.charAt(is.length() - 1) == js.charAt(0)) {
							nodeIds[j] = -1;
							nodes.get(i).p.add(j);
						}

					}
				}
			}
			int k = 0;
			int count=0;
			for (int i = 0; i < n; i++) {
				if (nodeIds[i] == 0) {
					k = i;
					count++;
				}
			}
			if(count>1){
				System.out.println("Head to tail ordering is not possible.");
				continue outer;
			}
			dfsRecurse(nodes, k,1);
			for (Node node : nodes) {
				if (!node.visited) {
					System.out.println("Head to tail ordering is not possible.");
					continue outer;
				}
			}
			System.out.println("Head to tail ordering is possible.");
		}
	}

	private static void dfsRecurse(ArrayList<Node> nodes, int i, int j) {
		nodes.get(i).visited = true;
		if (noUnvisited(nodes.get(i).p, nodes)){
			if(j<nodes.size())
				nodes.get(i).visited=false;
			return;
		}
		for (Integer nodeI : nodes.get(i).p) {
			if (!nodes.get(nodeI).visited) {
				dfsRecurse(nodes, nodeI, j + 1);

			}
		}
	}
	
	private static boolean  noUnvisited(ArrayList<Integer> p, ArrayList<Node> nodes){
		for(Integer i:p){
			if(!nodes.get(i).visited)return false;
		}
		return true;
	}
}
