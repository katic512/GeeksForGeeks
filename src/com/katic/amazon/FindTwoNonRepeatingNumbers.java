package com.katic.amazon;

import java.util.Scanner;

public class FindTwoNonRepeatingNumbers {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int s = in.nextInt();
		    s*=2;
		    s+=2;
		    int[] a = new int[s];
		    int xorSum = 0;
		    for(int i=0;i<s;i++){
		        a[i]=in.nextInt();
		        xorSum^=a[i];
		    }
		    int temp = xorSum;
		    int bitIndex =0;
		    while(temp>0){
		    	bitIndex++;
		    	if(temp%2==1){
		    		break;
		    	}
		    	temp/=2;
		    }
		    int[] g1 = new int[s];
		    int[] g2 = new int[s];
		    int g1Index=0,g2Index=0;
		    outer:for(int i=0;i<s;i++){
		    	temp=a[i];
		    	int tempBitIndex =1;
		    	while(temp>0 && tempBitIndex <=bitIndex){
		    		if(temp%2==1 && tempBitIndex==bitIndex){
		    			g1[g1Index++]=a[i];
		    			continue outer;
		    		}
		    		temp/=2;
		    		tempBitIndex++;
		    	}
		    	g2[g2Index++]=a[i];
		    }
		    int g1XorSum=0;
		    for(int k=0;k<g1Index;k++){
		    	g1XorSum^=g1[k];
		    }
		    int g2XorSum=0;
		    for(int k=0;k<g2Index;k++){
		    	g2XorSum^=g2[k];
		    }
		    if(g1XorSum>g2XorSum){
		    	System.out.println(g2XorSum + " " +g1XorSum);
		    }else{
		    	System.out.println(g1XorSum + " " +g2XorSum);
		    }
		}
	}
}
