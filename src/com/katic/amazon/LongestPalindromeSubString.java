package com.katic.amazon;

import java.util.Arrays;
import java.util.Scanner;

public class LongestPalindromeSubString {
	public static void main(String[] ar){
		Arrays.sort(new int[10]);
		recursiveMethod();
		/*Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			String s = in.next();
			int size = s.length();
			char[] c = s.trim().toCharArray();
			int[][] r = new int[size][size];
			int maxL =1;
			int st =-1;
			int end=-1;
			for(int l=0;l<=size;l++){
				int i=0,j=l;
				while(i<size && j<size){
					if(l==0){
						r[i][j]=1;
						if(i+1<size)
						r[i+1][j]=1;
					}else{
						int diag = r[i+1][j-1];
						if(c[j]==c[i] && diag ==1){
							r[i][j]=1;
							if(l+1>maxL){
								maxL=l+1;
								st=i;end=j;
							}
						}else{
							r[i][j]=0;
						}
					}
					i++;j++;
				}
			}
			if(st==-1){
    			System.out.println(s.substring(0, 1));
			}else{
    			System.out.println(s.substring(st, end+1));
			}
		}*/
	}
	
	private static void recursiveMethod(){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			String s = in.next();
			int size = s.length();
			char[] c = s.trim().toCharArray();
			r = new int[size][size];
			maxL = 1; start=-1;end=-1;
			recurse(c,0,size-1, size);
			System.out.println(maxL);
//			if(start==-1){
//    			System.out.println(s.substring(0, 1));
//			}else{
//    			System.out.println(s.substring(start, end+1));
//			}
		}
	}
	
	static int[][] r ;
	static int maxL,start,end;
	private static int recurse(char[] c, int i, int j, int size) {
		if(!(i>=0 && i<size && j>=0 && j<size))return 0;
		if(i==j)return 1;
		if(r[i][j]>0){
			if(r[i][j]>maxL){
				maxL = r[i][j];
				start = i;end=j;
			}
			return r[i][j];
		}
		if(c[i]==c[j]){
			if(i+1==j){
				return 2;
			}
			r[i][j] = recurse(c, i+1,j-1,size)+2;
		}else{
			r[i][j] = Math.max(recurse(c, i+1,j,size),recurse(c, i,j-1,size));
		}
		if(r[i][j]>maxL){
			maxL = r[i][j];
			start = i;end=j;
		}
		return r[i][j];
	}

}
