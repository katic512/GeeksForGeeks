package com.katic.amazon.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ReArrangeString {

    static class E{
        char c;
        int count;
        E(char c, int count){
            this.c = c;
            this.count = count;
        }
    }
    
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
		    t--;
		    char[] a = in.next().trim().toCharArray();
		    PriorityQueue<E> pq = new PriorityQueue<E>(new Comparator<E>(){
				@Override
				public int compare(E arg0, E arg1) {
					if(arg0.count < arg1.count)return 1;
					return -1;
				}
		    });
		    Map<Character, Integer> m = new HashMap<>();
		    for(int i=0; i<a.length; i++){
		    	if(m.containsKey(a[i])){
		    		m.put(a[i], m.get(a[i])+1);
		    	}else{
		    		m.put(a[i], 1);
		    	}
		    }
		    for(Character ch : m.keySet()){
		    	pq.add(new E(ch, m.get(ch)));
		    }
		    boolean flag = true;
		    char prev = '*';
		    while(pq.size()>0){
		    	E e = pq.poll();
		    	if(e.count==1  && pq.size()==0){ 
		    			break;
		    	}else if(e.count>1 && pq.size()==0){
		    		flag = false;break;
		    	}else{
		    		if(prev == e.c){
		    			E e2 = pq.poll();
		    			e2.count--;
		    			if(e2.count>0)pq.add(e2);
		    			pq.add(e);
		    			prev = e2.c;
		    		}else{
		    			prev = e.c;
		    			e.count--;
				    	if(e.count>0)pq.add(e);
		    		}
		    	}
		    }
		    if(flag){
		    	System.out.println(1);
		    }else{
		    	System.out.println(0);
		    }
		}
	}
	
	
}
