package com.katic.amazon;

import java.util.Scanner;

public class SubsetSum_Dp {
	public static void main(String...arg){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int s = in.nextInt();
			int[] a = new int[s];
			int sum=0;
			for(int i=0;i<s;i++){
				a[i] = in.nextInt();
				sum+=a[i];
			}
			if(sum%2!=0){
				System.out.println("NO");
				continue;
			}
			sum=sum/2;
			int[] r = new int[sum+1];
			r[0]=1;
			for(int j=0;j<s;j++){
				int[] tempR = new int[sum+1];
				for(int i=0;i<=sum;i++){
					if(i==0){
						tempR[i] = 1;
					}else{
						if(a[j]>i){
							tempR[i]=r[i];
						}else{
							if(r[i-a[j]]==1 ||r[i]==1){
								tempR[i]=1;
							}else{
								tempR[i]=0;
							}
						}
					}
				}
				r=tempR;
			}
			if(r[sum]==1){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}
