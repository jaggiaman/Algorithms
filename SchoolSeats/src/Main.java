
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	private static void getSchool(List<Integer> schoolSeats, List<Integer> studentScore, List<List<Integer>> studentPrefrence ) {
		Map<Integer,List<List<Integer>>> studentMap = new TreeMap<Integer, List<List<Integer>>>(Collections.reverseOrder());
		Iterator<List<Integer>> prefrenceIterator = studentPrefrence.iterator();
		for(int score : studentScore) {
			if(studentMap.containsKey(score)) {
				studentMap.get(score).add(prefrenceIterator.next());
			}
			else{
				List<List<Integer>> pref = new ArrayList();
				pref.add(prefrenceIterator.next());
				studentMap.put(score, pref);
			}
		}
		System.out.println(studentMap);
		Iterator i = studentMap.entrySet().iterator();
        int student = studentScore.size();
        int total = 0;
        for(int seats : schoolSeats){
        	total += seats;
        }
		while(i.hasNext()) {
			 Map.Entry me = (Map.Entry)i.next();
			 System.out.println(me.getValue());
			 prefrenceIterator =((List<List<Integer>>) me.getValue()).iterator();
			 while(prefrenceIterator.hasNext()) {
				 for(int index:  prefrenceIterator.next()){
					 if(schoolSeats.get(index)>0) {
						 schoolSeats.set(index,schoolSeats.get(index)-1);
						 total--;
						 student--;
						 break;
					 }
				 }
			 }
		}
	System.out.println("total School Left:"+total);
	System.out.println("total Student Left:"+student);
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
		
         getSchool(school,marks,pref);
}
}
