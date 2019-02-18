package string;

public class Palindrome {
	public static boolean isPalindrome(String str, int l, int h) {
		if(str=="")
			return false;
		if(l==h)
			return true;
		else {
			while(l<h) {
				if(str.charAt(l)!=str.charAt(h)) 
						return false;
				else {
					l++;
					h--;
				}
			}
			return true;
		}
		
	}

	public static void printPalindrome(String str) {
		int i=0;
		for(;i<str.length();i++) {
			int j=i;
			for(;j<str.length();j++)
				if(isPalindrome(str,i,j))
					System.out.println(str.substring(i, j+1));
		}
	}
	public static void main(String[] args) {
		String skills="nitin";
		printPalindrome(skills);
}
}
