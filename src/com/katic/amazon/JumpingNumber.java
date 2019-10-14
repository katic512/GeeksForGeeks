package com.katic.amazon;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class JumpingNumber {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int n = in.nextInt();
			List<String> r = new LinkedList<>();
			for(int i=0;i<=n;i++){
			    if(i<=10){
			        r.add(String.valueOf(i));
			    }else{
			        char[] c =String.valueOf(i).toCharArray();
			        if(jumpingNumber(c)){
			        	r.add(String.valueOf(i));
			        }
			    }
			}
			//String[] a = sortList(r.toArray(new String[r.size()]));
			Collections.sort(r,new Comparator<String>(){
                public int compare(String s1,String s2){
                	int q=0,k=0;
                	while(q<s1.length() && k<s2.length() ){
                    	if(s1.charAt(q)<s2.charAt(k)){
                    		return -1;
                    	}else if(s1.charAt(q)>s2.charAt(k)){
                    		return 1;
                    	}else if(s1.charAt(q)==s2.charAt(k)){
                    		q++;k++;
                    	}	
                	}
                	if(q==s1.length()-1 && k<=s2.length()-1){
                		return -1;
                	}else{
                		return 1;
                	}
                }});
			StringBuilder temp = new StringBuilder();
			for(String st:r){
				temp.append(st+" ");
			}
			System.out.println(temp);
		}
	}

	private static String[] sortList(String[] a) {
		for(int i=0;i<a.length-2;i++){
			int minIndex=i;
			for(int j=i+1;j<a.length;j++){
				
				if(a[j].charAt(0)<a[minIndex].charAt(0)){
					minIndex=j;
				}
			}
			if(i!=minIndex){
				String temp =a[i];
				a[i]=a[minIndex];
				a[minIndex]=temp;
			}
		}
		return a;
	}

	private static boolean jumpingNumber(char[] c) {
		char prev=c[0];
		for(int i=1;i<c.length;i++){
			if(Math.abs(prev-c[i])!=1){
				return false;
			}
			prev=c[i];
		}
		return true;
	}
}
