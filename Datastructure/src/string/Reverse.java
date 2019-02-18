package string;

public class Reverse {

	public static char[] reverse(char[] str) {
		 // Initialize left and right pointers 
        int r = str.length - 1, l = 0; 
        while (l < r) 
        { 
            if (!Character.isAlphabetic(str[l])) 
                l++; 
            else if(!Character.isAlphabetic(str[r])) 
                r--; 
  
            // Both str[l] and str[r] are not spacial 
            else 
            { 
                char tmp = str[l]; 
                str[l] = str[r]; 
                str[r] = tmp; 
                l++; 
                r--; 
            } 
        } 
        return str;
	}
	
	public static void main(String[] args) {
		char[] skills="a!!!b.c.d,e'f,ghi".toCharArray();
		System.out.println(reverse(skills));
}
	
	
}
