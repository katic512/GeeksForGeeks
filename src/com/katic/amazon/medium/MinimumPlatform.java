/**
 * @author Katic
 *
 * @source: http://practice.geeksforgeeks.org/problems/minimum-platforms/0
 */
package com.katic.amazon.medium;

import java.util.Scanner;

public class MinimumPlatform {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0){
            t--;
            int size = in.nextInt();
            int[] a = new int[size];
            int[] d = new int[size];
            for(int i=0;i<size;i++){
                a[i] = in.nextInt();
            }
            for(int i=0;i<size;i++){
                d[i] = in.nextInt();
            }
            int p = 0;
            for(int i=1;i<size;i++){
            	int tempP = 0;
                for(int j=i-1;j>=0;j--){
                	if(isIntersecting(a, d, j, i)){
                		tempP++;
                	}
                }
                if(tempP-p>0){
                	p += tempP-p;
                }
            }
            p = (size>0)?p+1:0;
            System.out.println(p);
        }
	}

	private static boolean isIntersecting(int[] a, int[] d, int j, int i) {
		if(a[i]>=d[j]){
			return false;
		}else if(a[i]<a[j] && (d[i]>=a[j] && d[i]<=d[j])){
			return true;
		}else if((a[i]>=a[j] && a[i]<=d[j])){
			return true;
		}
		return false;
	}

}
