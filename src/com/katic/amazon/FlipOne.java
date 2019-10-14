package com.katic.amazon;

import java.util.Scanner;

public class FlipOne {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int s = in.nextInt();
			int[] a = new int[s];
			a[0]=in.nextInt();
			int maxZeroCount=(a[0]==1)?-1:1;
			int tmpCnt=maxZeroCount;
			int oneCount =(a[0]==1)?1:0;
			for(int i=1;i<s;i++){
				a[i]=in.nextInt();
				if(a[i]==1){
					oneCount++;
				}
				int temp = (a[i]==1)?-1:1;
				tmpCnt = Math.max(tmpCnt+temp,temp);
				if(tmpCnt>maxZeroCount)maxZeroCount=tmpCnt;
			}

			/* int maxZeroCount=(a[0]==1)?-1:1;
			    int tmpCnt=maxZeroCount;
			    for(int i=1;i<s;i++){
			        int temp = (a[i]==1)?-1:1;
			        tmpCnt = Math.max(tmpCnt+temp,temp);
			        if(tmpCnt>maxZeroCount)maxZeroCount=tmpCnt;
			    }*/
			if(maxZeroCount<0){
				System.out.println(oneCount);
			}else{
				System.out.println(oneCount+maxZeroCount);
			}

		}

	}
}