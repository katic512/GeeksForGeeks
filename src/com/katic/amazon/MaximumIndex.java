package com.katic.amazon;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumIndex {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int s = in.nextInt();
			int[] a = new int[s+1];
			int max = -1;
			for(int i=1;i<=s;i++){
				a[i] = in.nextInt();
				if(a[i]>max)max=a[i];
			}
			int[] num = new int[max+1];
			Arrays.fill(num, -1);
			for(int i=1;i<=s;i++){
				num[a[i]] = i;
			}
			for(int i=1;i<num.length;i++){
				num[a[i]] = i;
			}
		}
	}

	/*public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
			int t = in.nextInt();
			while(t>0){
			    t--;
			    int s = in.nextInt();
			    int[] a = new int[s];
			    int end = s-1;
			    int max=1;
			    int st=s-1;
			    for(int i=0;i<s;i++){
			        a[i] = in.nextInt();
			    }
			    for(int i=s-1;i>=0;i--){
			        if(i!=s-1){
			            if(a[end] < a[i]){
    			             if((end-i-1)>max){
    			                 max = end-i-1;
    			             }   
			                st=i;
		                    end=i;
			            }else{
			                st=i;
			            }
			        }
			    }
			    if((end-st)>max) {max= end-st;}
			    max = s==1?0:max;
			    System.out.println(max);
			}
	}*/
}