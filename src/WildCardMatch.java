import org.junit.Test;


public class WildCardMatch {

    public boolean isMatch(String s, String p) {
    	int sLen = s.length();
    	int pLen = p.length();
    	int sIdx = 0;
    	int pIdx = 0;
    	int lastStar = -1;
    	int lastStarEnd = -1;
    	while(pIdx < pLen && sIdx < sLen){
    		char c = p.charAt(pIdx);
    		switch(c){
    		case '?':
    			if(pIdx == pLen -1){
    				if(sIdx == sLen -1){
    					return true;
    				} else {
    					if(lastStar >= 0){
        					pIdx = lastStar+1;
        					sIdx = ++lastStarEnd;
        				} else {
        					return false;
        				}
    				}
    			} else {
	    			sIdx++;
	    			pIdx++;
    			}    			
    			break;
    		case '*':
    			lastStar = pIdx;
    			lastStarEnd = sIdx;
    			if(pIdx == pLen -1)
    				return true;
    			pIdx++;
    			break;
    		default:
    			if(c == s.charAt(sIdx)){
    				sIdx++;
    				pIdx++;
    			} else {
    				if(lastStar >= 0){
    					pIdx = lastStar+1;
    					sIdx = ++lastStarEnd;
    				} else {
    					return false;
    				}
    			}
    			break;
    		}
    	}
    	
    	if((pIdx == pLen -1 && p.charAt(pIdx) == '*') || (pIdx > pLen-1 && sIdx == sLen)){
    		return true;
    	}
        return false;
    }
    
    @Test
    public void test(){
    	System.out.println(isMatch("aa","*a"));
    }
}
