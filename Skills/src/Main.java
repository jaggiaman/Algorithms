import java.util.HashMap;
import java.util.Map;

public class Main {

	private static void differentTeams(String skills) {
		int[] subj =new int[5];
		int len = skills.length();
		for (int i = 0; i < len; ++i)
		{
		    char charAt = skills.charAt(i);
		    switch(charAt) {
		    case 'p': subj[0]++;
		    			break;
		    case 'c': subj[1]++;
						break;
		    case 'm': subj[2]++;
						break;
		    case 'b': subj[3]++;
						break;
		    case 'z': subj[4]++;
						break;
		    
		    }
		}
		int minVal=subj[0];
		for(int i=0; i<5; i++) {
			if(minVal>subj[i])
				minVal=subj[i];
		}
		System.out.println(minVal);
		 
		
	}
	public static void main(String[] args) {
		String skills="pcmpp";
		differentTeams(skills);
}
}
