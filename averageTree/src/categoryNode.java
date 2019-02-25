import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


public class categoryNode{
	public int value;
	public ArrayList<categoryNode> subCategories;
	public categoryNode() {
		subCategories=new ArrayList<categoryNode>();
	}
	
	public categoryNode(int value) {
		this.value=value;
		this.subCategories=new ArrayList<categoryNode>();
	}
	
	
	
	public static void main(String[] args) {
		String str = "aaaawaglkg";
		int k=3;
		List<String> result = sub(str,k);
		for(String res:result)
			System.out.print(res+"\n");
	
			
		}
}
