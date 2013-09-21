
public class IsPalindrome {

    public boolean isPalindrome(String s) {
    	int len = s.length();
    	if(0 == len)
    		return true;
    	s = s.toLowerCase();
    	int start = 0;
    	int end = s.length() -1;
    	while(end >= start){
    		char ce = s.charAt(end);
    		char cs = s.charAt(start);
    		if(!((ce >= 'a' && ce <= 'z') || (ce >='0' && ce<='9'))){
    			end--;
    			continue;
    		}
    		if(!((cs >= 'a' && cs <= 'z') || (cs >='0' && cs<='9'))){
    			start++;
    			continue;
    		}
    		
    		if(cs == ce){
    			end--;
    			start++;
    		} else {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String args[]){
    	String s1 = "A man, a plan, a canal: Panama";
    	String s2 = "ab2a";
    	IsPalindrome ip = new IsPalindrome();
    	System.out.println(ip.isPalindrome(s1));
    	System.out.println(ip.isPalindrome(s2));
    }
}
