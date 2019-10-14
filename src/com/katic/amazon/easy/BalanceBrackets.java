package com.katic.amazon.easy;

import java.util.Scanner;
import java.util.Stack;
/**
 * 
 * @author Katic
 *
 * @source:https://practice.geeksforgeeks.org/problems/parenthesis-checker/0
 */
public class BalanceBrackets {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = Integer.valueOf(in.nextLine().trim());
		
		while(t>0){
			t--;
		    char[] c = in.nextLine().trim().toCharArray();
		    Stack<Character> s = new Stack<>();
		    boolean flag=true;
		    for(int i=0;i<c.length;i++){
		        if(s.size()==0){
		            s.push(c[i]);
		        }else{
		            if(c[i]=='{'||c[i]=='('||c[i]=='['||c[i]=='<'){
		                s.push(c[i]);
		            }else{
		                char temp = s.pop();
		                switch(c[i]){
		                    case '}':
		                        if(temp != '{'){
		                            flag =false;
		                        }
		                    break;
		                    
		                    case ']':
		                        if(temp != '['){
		                            flag =false;
		                        }
		                    break;
		                    
		                    case ')':
		                        if(temp != '('){
		                            flag =false;
		                        }
		                    break;
		                    
		                    case '>':
		                        if(temp != '<'){
		                            flag =false;
		                        }
		                    break;
		                }
		                if(!flag)break;
		            }
		        }
		    }
		    if(flag){
		    	System.out.println("balanced");
		    }else{
		    	System.out.println("not balanced");
		    }
		}
	}
}
