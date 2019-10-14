package com.katic.amazon.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NCr {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0){
        	t--;
            Map<String, Long> m = new HashMap<>();
            int n = in.nextInt();
            int r = in.nextInt();
            if(n<r){
                System.out.println(0);
                continue;
            }
            long temp = 1;
            m.put("0",(long)1);
            for(int i = 1;i<=n;i++){
            	temp= temp*i;
                m.put(""+i,(long)temp);
            }
            System.out.print("n"+m.get(""+n)+"  r:"+m.get(""+r)+"  n-r:"+m.get(""+(n-r)));
            long c = m.get(""+n)/(m.get(""+r)*m.get(""+(n-r)));
            System.out.println(c%(1000000007));
        }
	}
}
