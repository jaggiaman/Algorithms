package visa;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class maxStreak {

	private static int maxStreak(String data) {
		int len = data.length();
		char ch= data.charAt(len-1);
		int count=1;
		int max=1;
		int i=len-2;
		for(;i>=0;i--) {
			if(data.charAt(i)!=ch) {
				count++;
				if(count>max)
					max=count;
			}
			else
				count=1;
		}
		return max;
//		Iterator<String> it = data.iterator();
//		int count=0;
//		int max=0;
//		while(it.hasNext()) {
//			if(count(it.next(),'Y')==m) {
//				count++;
//				if(count>max) {
//					max=count;
//				}
//			}
//			else {
//				count=0;
//			}
//		}
//		return max;
	}
	public static int count(String s, char c) 
    { 
        int res = 0; 
  
        for (int i=0; i<s.length(); i++) 
        { 
            // checking character in string 
            if (s.charAt(i) == c) 
            res++; 
        }  
        return res; 
    } 
		
	public static void main(String[] args) {
		System.out.println(maxStreak("11111"));
}
}


