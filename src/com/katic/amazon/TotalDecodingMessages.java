package com.katic.amazon;

import java.util.Scanner;
/***
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/total-decoding-messages/0
 */
public class TotalDecodingMessages {

	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		outer:while(t>0){
		    t--;
		    int n = in.nextInt();
		    char[] digits = in.next().trim().toCharArray();
		    if(digits[0]=='0'){
                        System.out.println(0);
                        continue outer;
                    }
		    int[] count = new int[n]; // A table to store results of subproblems
            count[0] = 1;
              for (int i = 1; i <n; i++){
                count[i] = 0;
                // If the last digit is not 0, then last digit must add to
                // the number of words
                if (digits[i] > '0')
                    {count[i] = count[i-1];}
                    
                    if(digits[i]=='0' && (digits[i-1]>'2' || digits[i-1]<'1')){
                        //System.out.println(digits[i-2]+" "+digits[i-1]+" 0");
                        System.out.println("0");
                        continue outer;
                    }
                // If second last digit is smaller than 2 and last digit is
                // smaller than 7, then last two digits form a valid character
                if (digits[i-1] < '2' || (digits[i-1] == '2' && digits[i] < '7') ){
                	if(i>=2){
                		count[i] += count[i-2];
                	}else{
                		count[i] += count[i-1];	
                	}
                }
                    
            }   
            System.out.println(count[n-1]);
		}
	}
	
	
	
	
	/*public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    int s = in.nextInt();
		    char[] c = in.next().trim().toCharArray();
		    int i=s-1;
		    int[] a = new int[s];
		    int k=0;
		    while(i>=0){
		    	if(c[i]=='0'){
		    		a[k++]=Integer.parseInt(""+c[--i]+"0");
		    	}else{
		    		a[k++]=Integer.parseInt(c[i]+"");
		    	}
		    	i--;
		    }
		    i=0;
		    int j=k-1;
		    while(i<j){
		    	int temp = a[i];
		    	a[i] = a[j];
		    	a[j] = temp;
		    	i++;j--;
		    }
		    for(i=0;i<k;i++){
		    	System.out.print(a[i]+" ");
		    }
		    
		    int[] r = new int[k];
		    int pairCounter=0;
		    for(i=1;i<k;i++){
		    	if(possible(a,i)){
		    	    //r[i]=1;
		    	    pairCounter++;
		    	}
		    }
		    int result=1;
		    if(pairCounter!=0){
		        int x = pairCounter-1;
		        pairCounter=1;
		        while(x>0){
		            x--;
		            pairCounter*=2;
		        }
		        result+=pairCounter;
		    }
		    
		    System.out.println(result);
		}
	}

	private static boolean possible(int[] a, int i) {
		int t = 10*a[i-1]+a[i];
		if(t<26)return true;
		return false;
	}*/
}