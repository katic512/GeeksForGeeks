package com.katic.amazon;

import java.util.Arrays;
import java.util.Scanner;

public class LongestDistanceCharacter {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    char[] c = in.next().trim().toCharArray();
		    int[] a = new int[26];
		    int st=0;
		    int maxl = 1;
		    for(int i=0;i<c.length;i++){
		            if(a[c[i]-97]>=1){
		                if(maxl<st)maxl=st;
		                st=0;
		                Arrays.fill(a,0);
		            }else{
		                //System.out.println(c[i]);
		                a[c[i]-97]++;
		                st++;
		            }
		    }
		    System.out.println(maxl);
		}
	}
}
