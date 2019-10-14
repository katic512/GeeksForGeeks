package com.katic.amazon.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NQueenProblem {


	static boolean flag = false;
	static String finalOut = "";
	static List<String> pairs ;
	public static void main(String[] ar){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			finalOut = "";
			flag = false;
			pairs = new LinkedList<>();
			int n = in.nextInt();
			placeQueen(n, 0 , 0);
			if(!flag){
			    System.out.println("-1");
			}else{
			    System.out.println(finalOut);
			}
		}
	}
	
	private static void placeQueen(int n, int i, int j) {
		if(pairs.size()==n){
		    flag=true;
		    String out ="["; 
	        for(String s : pairs) {
				String[] v = s.split(",");
				int y = Integer.parseInt(v[1]);
				out+=y+1+" ";
	    	}
	    	out+="] ";
	    	finalOut+=out;
	    	return;
		}
		while(j<n){
			if(validPlace(i, j)){
				pairs.add(i+","+j);
				placeQueen(n, i+1, 0);
				pairs.remove(pairs.size()-1);
			}
			j++;
		}
	}

	private static boolean validPlace(int i, int j) {
		for(String s : pairs){
			String[] v = s.split(",");
			int x = Integer.parseInt(v[0]);
			int y = Integer.parseInt(v[1]);
			if(x==i || y == j)return false;
			if(Math.abs(x-i) == Math.abs(y-j))return false;
		}
		return true;
	}
}
