package com.katic.amazon;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PermutationWithSpaces {
	public static void main(String[] areg){ 
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			char[] s = in.next().toCharArray();
			int[] sp = new int[s.length-1];
			Set<String> ans = new TreeSet<>();
			permutate(sp, s, ans);
			for(String st : ans){
				System.out.print(st);
			}
			System.out.print("\n");
		}
	}

	private static void permutate(int[] sp, char[] s, Set<String> ans) {
		formatAndAdd(sp, s, ans);
		for(int i=0;i<sp.length;i++){
			if(sp[i]==0){
				sp[i]=1;
				permutate(sp, s, ans);
				sp[i]=0;
			}
		}
	}

	private static void formatAndAdd(int[] sp, char[] s, Set<String> ans) {
		int spIndex = 0, sIndex=0;
		String temp = "("+ s[sIndex++];
		while(sIndex<s.length){
			if(sp[spIndex++]==1){
				temp+=" ";
			}
			temp+=s[sIndex++];
		}
		temp+=")";
		ans.add(temp);
	}
}
