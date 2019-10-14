package com.katic.amazon.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordBoggle {
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine().trim());
		while(t>0){
			t--;
			int wc = Integer.parseInt(in.nextLine().trim());
			String[] w = in.nextLine().trim().split(" ");
			String[] dim = in.nextLine().trim().split(" ");
			int n = Integer.parseInt(dim[0]);
			int m = Integer.parseInt(dim[1]);
			char[][] matrix = new char[n][m];
			char[] line = in.nextLine().trim().replaceAll(" ", "").toCharArray();
			int lineIndex = 0;
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					matrix[i][j] = line[lineIndex++];
				}
			}
			List<String> result = new ArrayList<>();
			outer:for(int k = 0; k <w.length; k++){
				for(int i=0; i<n; i++){
					for(int j=0; j<m; j++){
						if(w[k].charAt(0) == matrix[i][j]){
							boolean[][] mat = new boolean[n][m];
							recurse(n, m, matrix,i, j, w[k],0,  "", result, mat);
							if(result.contains(w[k]))
							continue outer;
						}
					}
				}
			}
			Collections.sort(result);
			for(String st: result){
				System.out.print(st+" ");
			}
		}
	}

	private static void recurse(int n, int m, char[][] matrix,int i, int j, String word,  int wordIndex, String string, List<String> result, boolean[][] mat) {
		if(word.equals(string) && !result.contains(word)){
			result.add(string);return;
		}
		if(i>=0 && i<n && j>=0 && j<m && wordIndex<word.length() &&matrix[i][j]==word.charAt(wordIndex) && mat[i][j] == false){
			mat[i][j] = true;
			string+=matrix[i][j];
			recurse(n, m, matrix, i+1, j, word, wordIndex+1, string, result, mat);
			recurse(n, m, matrix, i, j+1, word, wordIndex+1, string, result, mat);
			recurse(n, m, matrix, i-1, j, word, wordIndex+1, string, result, mat);
			recurse(n, m, matrix, i, j-1, word, wordIndex+1, string, result, mat);
			recurse(n, m, matrix, i+1, j+1, word, wordIndex+1, string, result, mat);
			recurse(n, m, matrix, i+1, j-1, word, wordIndex+1, string, result, mat);
			recurse(n, m, matrix, i-1, j-1, word, wordIndex+1, string, result, mat);
			recurse(n, m, matrix, i-1, j+1, word, wordIndex+1, string, result, mat);	
		}
	}

}
