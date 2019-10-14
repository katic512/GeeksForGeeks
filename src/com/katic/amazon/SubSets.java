package com.katic.amazon;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SubSets {
	
	public static void main(String[] areg){ 
	Scanner in = new Scanner(System.in);
	int t = in.nextInt();
	while(t>0){
		t--;
		int s = in.nextInt();
		int[] a = new int[s];
		for(int i =0; i<s; i++){
			a[i] = in.nextInt();
		}
		Set<String> ans = new LinkedHashSet<>();
		// pass array, startIndex, LengthToprocess, ans set, temp string
		generateSubsets(a,0,ans);
		String finalOut = "()";
	    for(String st: ans){
	        finalOut+="("+st.trim()+")";
	    }
        System.out.println(finalOut);
	}
}

	private static void generateSubsets(int[] a,int start,Set<String> ans ) {
		if(start>=a.length)return;
		String temp=a[start]+" ";
		int i=start+1;
		ans.add(temp);
		while(i<a.length){
			for(int j=i;j<a.length;j++){
				temp+=a[j]+" ";
				ans.add(temp);
			}
			temp=a[start]+" ";
			i++;
		}
		generateSubsets(a, start+1, ans);
	}
}
