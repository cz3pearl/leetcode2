import org.junit.Test;


public class ImplementStr {
    public String strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        for(int start = 0; start <= hLen - nLen; start++){
        	boolean flag = false;
        	for(int i = 0; i < nLen; i++){
        		if(haystack.charAt(start+i) != needle.charAt(i)){
        			flag = true;
        			break;
        		}
        	}
        	if(!flag)
        		return haystack.substring(start);        	
        }
        return null;        
    }
    
    @Test
    public void test(){
    	System.out.println(strStr("","a"));
    }
}
