/**
 * @author Katic
 *
 * @source: 
 */
package com.katic.amazon.medium;

import java.util.ArrayList;

public class MergeKSortedArraysInMatrixForm {

	public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
	{
		int[] r = new int[k*k];
		for(int i=0;i<k;i++){
			r[i] = arrays[0][i];            
		}
		for(int i=1;i<k;i++){
			r = merge(r,(i*k),arrays[i],k);
		}
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0;i<r.length;i++)result.add(r[i]);
		return result;
	}

	private static int[] merge(int[] a, int i, int[] b, int j){
		int[] r = new int[j*j];
		int x = 0, y=0, z=0;
		while(y<i || z<j ){
			int temp = 0;
			if(y<i && z<j ){
				if(a[y]<b[z]){
					temp = a[y];
					y++;
				}else{
					temp = b[z];
					z++;
				}
			}else if(y<i){
				temp = a[y];
				y++;
			}else{
				temp = b[z];
				z++;
			}
			r[x++] = temp;
		}
		return r;
	}
}
