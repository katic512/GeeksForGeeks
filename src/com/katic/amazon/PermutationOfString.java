package com.katic.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PermutationOfString {

	private static Set<String> resultSet;
	
	public static void main(String[] ar){
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		while(t>0){
			t--;
			char[] a = in.next().trim().toCharArray();
			int s = a.length;
			resultSet = new TreeSet<>();
			Map<Character,Integer> countMap = new HashMap<>(); 
			for(int i=0;i<s;i++){
				if(countMap.containsKey(a[i])){
					countMap.put(a[i], countMap.get(a[i])+1);
				}else{
					countMap.put(a[i], 1);
				}
			}
			char[] aCopy = new char[countMap.size()];
			int[] aCount = new int[countMap.size()];
			int k=0;
			for(Character ch : countMap.keySet()){
				aCopy[k] = ch;
				aCount[k++] = countMap.get(ch);
			}
			char[] r = new char[s];
			permutate(aCopy,aCount,r,0);
			String tempst = "";
			for(String st:resultSet){
				tempst+=st+" ";
			}
			System.out.println(tempst);
		}
	}

	private static void permutate(char[] aCopy, int[] aCount, char[] r, int i) {
		if(i==r.length){
			resultSet.add(String.valueOf(r));
			return;
		}
		for(int k=0;k<aCopy.length;k++){
			if(aCount[k]!=0){
				aCount[k]--;
				r[i]=aCopy[k];
				permutate(aCopy,aCount,r,i+1);
				aCount[k]++;
			}
		}
	}
}
