/**
 * @author Katic
 *
 * @source: https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair/0
 */
package com.katic.amazon.medium;

import java.util.Scanner;

public class CountWaysToReachNthStair {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int s = in.nextInt();
		    int [] a = new int[s+1];
		    if(s<=2){
		        System.out.println(s);
		        continue;
		    }
		    a[1]=1;
		    a[2] = 2;
		    for(int i=3;i<=s;i++){
		        a[i]=a[i-1]+a[i-2];
		        if(a[i]>=1000000007)
		        a[i]=a[i]%1000000007;
		    }
		    System.out.println((a[s]));
		}
	}
}