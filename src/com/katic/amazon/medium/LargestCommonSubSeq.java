/**
 * @author Katic
 *
 * @source: 
 */
package com.katic.amazon.medium;

import java.util.Arrays;
import java.util.Scanner;

public class LargestCommonSubSeq {

	public static void main(String... arg){
		Scanner in =  new Scanner(System.in);
		int s = in.nextInt();
		int[] a = new int[s];
		for(int i=0;i<s;i++){
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		for(int i=0;i<s;i++){
			System.out.print(a[i]+",");
		}
		System.out.println();
		System.out.println(findLongestConseqSubseq(a,s));
	}

	private static int findLongestConseqSubseq(int a[], int n)
	{
		
		int max = 0;
		int temp = 0;
		for(int i=1;i<a.length;i++){
			if(temp>max)max = temp;
			if(a[i]==a[i-1])continue;
			if(a[i]-a[i-1]==1){
				temp++;
			}else{
				temp = 0;
			}
		}
		if(temp>max)max = temp;
		return max+1;
	}
}
