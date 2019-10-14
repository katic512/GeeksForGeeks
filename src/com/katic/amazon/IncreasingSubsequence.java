package com.katic.amazon;

import java.util.Scanner;
/*******
 * 
 * @author Katic
 *
 * @source:
 */
public class IncreasingSubsequence {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int s = in.nextInt();
		    int[] a = new int[s];
		    for(int i=0;i<s;i++){
		        a[i]=in.nextInt();
		    }
		    int[] r = new int[s];
		    r[0]=a[0];
		    int max = r[0];
		    for(int i=1;i<s;i++){
		        int j=0;
		        while(j<i){
		            if(a[j]<a[i]){
		                r[i]=Math.max(r[i],r[j]+a[i]);
		            }else {
		            	r[i]=Math.max(r[i], a[i]);
		            }
		            j++;
		            if(r[i]>max)max=r[i];
		        }
		    }
		    System.out.println(max);
		}
	}
}
