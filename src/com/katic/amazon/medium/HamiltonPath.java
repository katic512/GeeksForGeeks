
package com.katic.amazon.medium;
/**
 * @author Katic
 *
 * @source: https://practice.geeksforgeeks.org/problems/hamiltonian-path/0
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HamiltonPath {
	
	static class Node{
		List<Integer> path;
		boolean visited;
		Node(){
			path = new ArrayList<>();
		}
	}
	
	public static void main(String[] arg){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int n = in.nextInt();
			int m = in.nextInt();
			List<Node> v = new ArrayList<>();
			for(int i=0;i<=n;i++)v.add(new Node());
			for(int i=0;i<m;i++){
				int s = in.nextInt();
				int d = in.nextInt();
				v.get(s).path.add(d);
				v.get(d).path.add(s);
			}
			boolean temp = false;
			for(int i=1;i<=n;i++){
				temp = dfsRecurse(v, i, 1);
				//System.out.println(temp);
				if(temp)break;
			}
			if(temp){
				System.out.println(1);
			}else{
				System.out.println(0);
			}
		}
	}

	private static boolean dfsRecurse(List<Node> nodes, int i, int j) {
		//System.out.println("i:"+i+"  j:"+j);
		nodes.get(i).visited = true;
		if (noUnvisited(nodes.get(i).path, nodes)){
			if(j<nodes.size()-1)
				{
					nodes.get(i).visited=false;
					return false;
				}
			return true;
		}
		boolean possiblePath = false;
		for (Integer nodeI : nodes.get(i).path) {
			if (!nodes.get(nodeI).visited) {
				possiblePath = dfsRecurse(nodes, nodeI, j + 1) || possiblePath;

			}
		}
		if(!possiblePath)nodes.get(i).visited = false;
		return possiblePath;
	}
	
	private static boolean  noUnvisited(List<Integer> p, List<Node> nodes){
		for(Integer i:p){
			if(!nodes.get(i).visited)return false;
		}
		return true;
	}

}
