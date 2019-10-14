 package com.katic.amazon.medium;

import java.util.Scanner;
/***
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps/0
 */
public class MinNumberOfJumps {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int s = in.nextInt();
			int[] a = new int[s];
			for(int i=0;i<s;i++){
				a[i]=in.nextInt();
			}
			
			/***
			 * The Algorithm:
			 * 		traverse the array when there is a jump increase jump count. Take the highest number 
			 * between current jump point and the current maximum index reachable and set it as next jump point  
			 */
			
			int jump=1;
			int i=0;
			//if first element is zero then no jump
			if(a[i]==0){
				jump=-1;
			}else{
				//maximum index that is reachable from current index
				int currLimit = a[i];
				//since first array index is visited moving to next index
				i++;
				int max = i;
				//exit while when reached end of array
				while(i<s){
					//exit when maximum index that can be reachable is greater that size
					if(currLimit>=s)break;
					
					if(currLimit == i){//reached current maximum index so decide for next maximum index
						if(a[i]==0){//before reaching end of array we have reached zero so cant proceed
							jump=-1;
							break;
						}
						jump++;
						i=max;
						currLimit=i+a[i];
						max++;
					}else{
						if(a[max]<a[i]){
							max = i;
						}
					}
					i++;
				}
			}
			System.out.println(jump);
		}
	}
}