package com.katic.amazon;

import java.util.Arrays;
import java.util.Scanner;

public class CheckValidSuduko {
	
	static int[] minSum = new int[10];
	static int[] maxSum = new int[10];

	public static void main(String[] arg){
		Scanner in =  new Scanner(System.in);
		int t = in.nextInt();
		int v = 1;
		minSum[0]=maxSum[0]=45;
		minSum[9]=maxSum[9]=0;
		while(v<9){
			int min = 45,max=45;
			int j=v, i=9, k=1;
			while(j>0){
				j--;
				min-=i;
				max-=k;
				k++;
				i--;
			}
			minSum[v]=min;
			maxSum[v]=max;
			v++;
		}
		for(int i=0;i<=9;i++){
			System.out.println("i:"+i+" minSum:"+minSum[i] + " maxSum:"+ maxSum[i]);
		}
		while(t > 0){
			t--;
			int[][] m = new int[9][9];
			for(int i=0; i<9;i++){
				for(int j=0; j<9; j++){
					m[i][j] = in.nextInt();
				}	
			}
			System.out.println(validate(m));
		}
	}

	private static int validate(int[][] m) {

		for(int i=0; i<9;i++){
			int rowSum = 0;
			int zeroCellCount = 0;
			boolean[] nums = new boolean[9];
			Arrays.fill(nums, false);
			for(int j=0; j<9; j++){
				if(m[i][j]==0){
					zeroCellCount++;
				}else{
					if(nums[m[i][j]-1]){
						return 0;
					}else{
						nums[m[i][j]-1]=true;
					}
					rowSum+= m[i][j];
				}
			}
			if(checkSum(zeroCellCount,rowSum)==0)return 0;
		}
		
		for(int j=0; j<9;j++){
			int colSum = 0;
			int zeroCellCount = 0;
			boolean[] nums = new boolean[9];
			Arrays.fill(nums, false);
			for(int i=0; i<9; i++){
				if(m[i][j]==0){
					zeroCellCount++;
				}else{
					if(nums[m[i][j]-1]){
						return 0;
					}else{
						nums[m[i][j]-1]=true;
					}
					colSum+= m[i][j];
				}
			}
			if(checkSum(zeroCellCount,colSum)==0)return 0;
		}
		return 1;
	}

	private static int checkSum(int k, int sum) {
		if(sum>=minSum[k] && sum <= maxSum[k])return 1;
		return 0;
	}
}
