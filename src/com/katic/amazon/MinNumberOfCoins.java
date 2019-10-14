package com.katic.amazon;

import java.util.Arrays;
import java.util.Scanner;

public class MinNumberOfCoins {

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int c = in.nextInt();
		    int s = in.nextInt();
		    int[] a = new int[s];
		    for(int i=0;i<s;i++){
		        a[i] = in.nextInt();
		    }
		    Arrays.sort(a);
		    int[] r = new int[c+1];
		    for(int i=0;i<a.length;i++){
		        int[] temp = new int[c+1];
		        for(int j=1;j<=c;j++){
		            if(a[i]==j){
		                temp[j]=1;
		            }else if(a[i]>j){
		                temp[j]=r[j];
		            }else{
		                if(temp[j-a[i]]!=0){
		                    temp[j]=temp[j-a[i]]+1;
		                    if(r[j]!=0){
                                temp[j]=temp[j]>r[j]?r[j]:temp[j];		                        
		                    }
		                }else{
		                    temp[j]=r[j];
		                }
		            }
		        }
		        r = temp;
		    }
		    r[c]=r[c]==0?-1:r[c];
		    System.out.println(r[c]);
		}
	}
}
