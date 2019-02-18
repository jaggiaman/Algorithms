package maxStreak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class maxStreak1 {

	private static int maxStreak(int m,List<String> data) {
		Iterator<String> it = data.iterator();
		int count=0;
		int max=0;
		while(it.hasNext()) {
			if(count(it.next(),'Y')==m) {
				count++;
				if(count>max) {
					max=count;
				}
			}
			else {
				count=0;
			}
		}
		return max;
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
		 Scanner scan = new Scanner(System.in);
         List<Integer> school = new ArrayList();
         System.out.println("Enter number of schools & seats");
         int school_no = scan.nextInt();
         for(int i=0;i<school_no;i++){
             school.add(scan.nextInt());
         }
         
         System.out.println("Enter number of students & marks");
         List<Integer> marks = new ArrayList();
         int marks_no = scan.nextInt();
         for(int i=0;i<marks_no;i++){
             marks.add(scan.nextInt());
         }

         
         System.out.println("Enter number of pref & schools");
         List<List<Integer>> pref = new ArrayList();
         for(int i=0;i<marks_no;i++){
             pref.add(new ArrayList());
             for(int j=0;j<3;j++){
                 pref.get(i).add(scan.nextInt());
             }
         }
		
}
}

