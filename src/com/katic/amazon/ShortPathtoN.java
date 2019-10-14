package com.katic.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShortPathtoN {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int n = in.nextInt();
		    ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		    int[] d = new int[n+1];
		    int[] p = new int[n+1];
		    Arrays.fill(d, Integer.MAX_VALUE);
		    al.add(0, new ArrayList<Integer>());
		    d[1] = 0;
		    p[1] = 1;
		    for(int i = 1; i<n+1; i++){
		    	ArrayList<Integer> temp = new ArrayList<>();
		    	if(i+1 <= n){
			    	temp.add(i+1);
			    	if(i*3 <= n){
			    		temp.add(3*i);
			    	}
		    	}
		    	al.add(i, temp);
		    }
		    for(int i = 1; i<n+1; i++){
		    	ArrayList<Integer> temp = al.get(i);
		    	for(Integer it : temp){
		    		if((d[i] + 1) < d[it]){
		    			d[it] = d[i]+1;
		    			p[it] = i;
		    		}
		    	}
		    	//System.out.println("i:"+i+"  d[i]:"+ d[i] +" p[i]:"+p[i]);
		    }
		    System.out.println(d[n]);
		}
	}
	 
}