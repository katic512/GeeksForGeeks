package com.katic.amazon;

import java.util.Scanner;

public class MajorityElements {

		public static void main (String[] args) {
		//code
			Scanner in = new Scanner(System.in);
			int t = in.nextInt();
			while(t>0){
			    t--;
			    int s = in.nextInt();
			    int[] a = new int[s];
			    int max =0;
			    for(int i=0;i<s;i++){
			        a[i] = in.nextInt();
			        if(a[i]>max) max= a[i];
			    }
			    //System.out.println(max);
			    int[]  c = new int[max+1];
			    for(int i=0;i<s;i++){
			        c[a[i]]++;
			    }
			    max=0;
			    for(int i=0;i<c.length;i++){
			         if(c[i]>c[max]) max= i;
			    }
				   System.out.println(max+":"+c[max]);
			    if(c[max] > s/2){
			    	System.out.println(max);
			    	
			    }else{	
			    	System.out.println("NO Majority Element");
			    }
			}
		}
	}