package com.katic.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class CombinationSum2 {

	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int s = in.nextInt();
		    int[] a = new int[s];
		    for(int i =0; i<s; i++){
		    	a[i] = in.nextInt();
		    }
		    int sum = in.nextInt();
		    Arrays.sort(a);
		    Set<String> ans = new LinkedHashSet<>();
		    generateCombination(a, ans, 0, 0, "", sum);
            String finalOut = "";
		    for(String st: ans){
		        finalOut+="("+st.trim()+")";
		    }
		    if(ans.size()==0){
		        System.out.println("Empty");
		    }else{
		        System.out.println(finalOut);
		    }
		}
	}

	private static void generateCombination(int[] a, Set<String> ans, int start,  int tempSum, String st ,int sum) {
		if(tempSum == sum){
			ans.add(st);
			return;
		}
		if(tempSum>sum)return;
		for(int j=start; j<a.length; j++){
			String tempSt = st;
			st+=a[j]+" ";
			tempSum+=a[j];
			if(tempSum>sum)return;
			start = j+1;
			generateCombination(a, ans, start, tempSum, st, sum);
			st = tempSt;
			tempSum-=a[j];
		}
	}

}
  