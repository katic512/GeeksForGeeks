package com.katic.amazon.hard;

import java.util.Arrays;
import java.util.Scanner;

public class SudokoSolver {

	public static void main(String[] ar){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int[][] m = new int[9][9];
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					m[i][j] = in.nextInt();
				}
			}
			solve(m, 0 ,0);
			String out = "";
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					out+=m[i][j]+" ";
				}
				out+="\n";
			}
			System.out.println(out);
		}
	}

	private static boolean solve(int[][] m, int rowNum, int colNum) {
		if(colNum>=9){
			return solve(m, rowNum+1, 0);
		}
		if(rowNum>=9)return true;
		if(m[rowNum][colNum]!=0){
			return solve(m, rowNum, colNum+1); 
		}
		
		boolean[] nums = new boolean[9];
		Arrays.fill(nums, false);
		//row process
		for(int i=0; i<9; i++){
			if(m[rowNum][i]!=0){
					nums[m[rowNum][i]-1] = true;
			}
		}
		//col process
		for(int i=0; i<9; i++){
			if(m[i][colNum]!=0){
					nums[m[i][colNum]-1] = true;
			}
		}
		//box process
		int x = getRange(rowNum);
		int y = getRange(colNum);
		int xLimit = x+3, yLimit=y+3;
		while(x<xLimit){
			int yT = y;
			while(yT<yLimit){
				if(m[x][yT]!=0){
					nums[m[x][yT]-1] = true;
				}
				yT++;
			}
			x++;
		}
		//set value
		boolean valSet = false;
		for(int i=0;i<9;i++){
			if(nums[i]==false && m[rowNum][colNum]==0){
				m[rowNum][colNum] = i+1;
				if(solve(m, rowNum, colNum+1)){
					valSet = true;
					break;
				}else{
					m[rowNum][colNum] = 0;
				}
			}
		}
		return valSet;
	}

	private static int getRange(int n) {
			if(n>=0 && n<=2){
				return 0;
			}else if(n>=3 && n<=5){
				return 3;
			}
		return 6;
	}
}
