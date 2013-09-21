import org.junit.Test;


public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int count = 0;
        int len = strs.length;
        if(0 == len)
        	return "";
        String first = strs[0];
        int firstLen = first.length();
        if(0 == firstLen){
        	return "";
        }
        boolean finished = false;
        while(!finished){
        	if(count == firstLen){
        		break;
        	}
        	char c = first.charAt(count);
        	for(int i = 1; i < len ; i++){
        		String curr = strs[i];
        		if(curr.length() > count && c == curr.charAt(count)){
        		} else {
        			finished = true;
        		}
        	}
        	if(!finished){
        		count++;
        	}
        }
        
        return first.substring(0, count);
    }
    
    @Test
    public void test(){
    	String[] test = new String[]{"a","ab"};
    	System.out.println(longestCommonPrefix(test));
    }
}
