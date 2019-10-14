package com.katic.amazon;

import java.util.Scanner;

public class RemoveCharacter {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			StringBuilder str1 = new StringBuilder(in.next());
			String str2 = in.next();
			for(int i=0;i<str1.length();i++) {
				if(str2.contains(str1.subSequence(i, i+1))) {
					str1.deleteCharAt(i);
					i--;
				}
			}
			System.out.println(str1);
		}
	}
}
