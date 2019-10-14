package com.katic.amazon;

import java.util.Scanner;

public class FindElementInRotatedArray {
		    	public static void main (String[] args) {
			Scanner in = new Scanner(System.in);
			int t = in.nextInt();
			while(t>0){
			    t--;
			    int s = in.nextInt();
			    int[] a = new int[s];
			    for(int i=0;i<s;i++){
			        a[i] = in.nextInt();
			    }
			    int n = in.nextInt();
			    int index = findMid(a,0,s-1); 
			    index = index == -1?s-1:index;
			    if(a[index] == n) {
			        System.out.println(index);
			    }else{
			    	if(a[index]>=n && a[0]<= n){
				        index = findNum(a,0,index,n);
				    }else if(a[index+1]<=n && n<=a[s-1]){
				        index = findNum(a,index,s-1,n);    
				    }else{
				        index=-1;
				    }
				    index = index !=-1?index+1:index;
				    System.out.println(index);	
			    }
			}
		}
		
		private static int findNum(int[] a, int i, int j, int n){
		    if(Math.abs(j-i) == 1) {
		        int index = (a[j]==n)?j:((a[i]==n)?n:-1);
		        return index;   
		    }
		    int m = (j-i)/2+i;
		    if(a[m]==n) return m;
		    if(a[i] == n) return i;
		    if(a[j] == n) return j;
		    if(a[i]<n && a[m]>n){
			        return findNum(a,i,m,n);
			    }else if(a[m]<n && n<a[j]){
			        return findNum(a,m,j,n);    
			    }else{
			        return -1;
			    }
		    
		}
		private static int findMid(int[] a,int i, int j){
		   
		    int m = (j-i)/2+i;
		    if(m == i) return -1;
		    if(m-1>=0){
		        if(a[m-1]>a[m])return m-1;
		    }
		    if(m+1<a.length){
		        if(a[m]>a[m+1]) return m;
		    }
		    if(a[m]<=a[j]){
		        return findMid(a, i,m);
		        
		    }else {
		        return findMid(a, m,j);
		        
		    }
		}
	}