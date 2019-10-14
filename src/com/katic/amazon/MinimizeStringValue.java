package com.katic.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimizeStringValue {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    char[] c = in.next().trim().toCharArray();
		    int k = in.nextInt();
		    Map<Character,Integer> m = new HashMap<>();
		    for(int i=0;i<c.length;i++){
		        if(m.containsKey(c[i])){
		            m.put(c[i], m.get(c[i])+1);
		        }else{
		            m.put(c[i], 1);
		        }
		    }
		    while(k>0 && !m.isEmpty()) {
		        k--;
		        char maxChar = ' ';
		        int max =0;
		        for(Character ch : m.keySet()) {
		            int value = m.get(ch);
		            if(max < value) {
		                maxChar = ch;
		                max = value;
		            }
		        }
		        max--;
		        if(max == 0) {
		            m.remove(maxChar);
		        }else {
		            m.put(maxChar, max);
		        }
		    }
		    int minSum =0;
		    for(Character ch : m.keySet()) {
		        int chVal = m.get(ch);
		        minSum =minSum+(chVal * chVal);
		    }
		    System.out.println(minSum);
		}
	}
}
