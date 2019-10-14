package com.katic.amazon.hard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/a-simple-fraction/0
 * 
 * @logic: save reminders in hash map and if it occurs again stop and form the decimal
 */
public class ASimpleFraction {
	

		public static void main (String[] args) {
			//code
			Scanner in = new Scanner(System.in);
			int t = in.nextInt();
			while(t>0){
				t--;
				int[] decimals = new int[20000];
				int di=-1;
 				Map<Integer,Integer> map = new HashMap<>();
				String decimal = "";
				int n = in.nextInt();
				int d = in.nextInt();
				if(n%d==0){
					System.out.println(n/d);
					continue;
				}
				int q = n/d;
				int r = n%d;
				String temp=q+".";
				n=r;
				while(true){
					if(n==0){
						temp+=decimal;
						break;	
					}
					if(n<d)n*=10;
					q = n/d;
					r = n%d;
					decimals[++di]=q;
					decimal+=q;
					if(map.containsKey(n)){
						int rIndex = map.get(n);
						decimal ="";
						for(int x=0;x<di;x++){
							if(x==rIndex){
								decimal+="("+decimals[x];
							}else{
								decimal+=decimals[x];
							}	
						}
						decimal+=")";
						temp+=decimal;
						break;	
					}else{
						System.out.println("n : " + n + " di:  " + di + " Q: " + q);
						map.put(n, di); 
					}
					n=r;
				}
				System.out.println(temp);
			}
		}
	}
