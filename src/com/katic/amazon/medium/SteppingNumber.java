package com.katic.amazon.medium;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SteppingNumber {
	private static int count = 0;
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
        
		while(t>0){
		    t--;
		    count = 0;
		    Set<Integer> nums = new HashSet<>();
		    int n = in.nextInt();
		    int m = in.nextInt();
		    for(int i=0; i<=9;i++){
		    	recurse(i, n, m, nums);
		    }
		    System.out.println(count);
		}
	}

	private static void recurse(int i, int n, int m, Set<Integer> nums) {
		if(i>=n && i<=m && !nums.contains(i)){
			//System.out.print(i+" ");
			nums.add(i);
			count++;
		}
		if(i>m)return;
		int ones = i%10;
		int first = i*10 + (ones-1);
		int second = i*10 + (ones+1);
		String firstSt = String.valueOf(first);
		String secondSt = String.valueOf(second);
		if(firstSt.charAt(firstSt.length()-1) != '9'){
			recurse(first, n, m, nums);
		}
		if(secondSt.charAt(secondSt.length()-1) != '0' ){
			recurse(second, n, m, nums);
		}
	}
}
