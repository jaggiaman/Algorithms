import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


public class subString {
	static HashMap<Character,Integer> map= new HashMap<Character,Integer>();
	public static List<String> sub(String str, int k){
//		char[] arr = str.toCharArray();
		if(str==null)
			return null;
					
		int len=str.length();
		
		List<String> result=new  ArrayList();
		if(len<k||k<=0) {
			return result;
		}
		int start=0;
		int end=k-1;
//		check(arr,start,end)
		for(int i=start;i<=end;i++) {
			char ch=str.charAt(i);
			if(map.containsKey(ch))
				map.put(ch,map.get(ch)+1);
			else
				map.put(ch,1);
		}
		if(check(k))
			result.add(str.substring(start, end+1));
		char remove;
		char add;
		
		while(end<len-1) {
			end++;
			remove=str.charAt(start);
			add=str.charAt(end);
			if(map.get(remove)>1)
				map.put(remove,map.get(remove)-1);
			else
				map.remove(remove);
			if(map.containsKey(add))
				map.put(add,map.get(add)+1);
			else
				map.put(add, 1);
			start++;
			if(check(k))
				result.add(str.substring(start, end+1));
			
		}
		
		return result;
	}
	public static boolean check(int k) {
		if(map.size()==k-1)
			return true;
		else
			return false;
		
	}
	
	
	
	public static void main(String[] args) {
		String str = "abcdbcdpmnmabcdb";
		int k=4;
		List<String> result = sub(str,k);
		for(String res:result)
			System.out.print(res+"\n");
	
			
		}
}
