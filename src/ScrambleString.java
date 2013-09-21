
public class ScrambleString {

//    public boolean isScramble(String s1, String s2) {
//        int len1 = s1.length();
//        int len2 = s2.length();
//        if(len1 != len2){
//        	return false;
//        } else {
//        	if(1 == len1){
//        		return s1.equals(s2);
//        	} else {
//        		for(int i = 1; i < len1; i++){
//        			if(
//        					(
//        							isScramble(s1.substring(0,i), s2.substring(0,i))
//        							&&isScramble(s1.substring(i),s2.substring(i))
//        					)||(
//        							isScramble(s1.substring(0,i), s2.substring(len1-i))
//        							&&isScramble(s1.substring(i),s2.substring(0,len1-i))
//        					)
//        			)
//        				return true;
//        		}
//        		return false;
//        	}
//        }
//    }
	private static final int UNSET = 0;
	private static final int TRUE = 1;
	private static final int FALSE = -1;
	public boolean isScramble(String s1, String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 == len2){
			int len = len1;
			int[][][] attach = new int [len][len][len];
			return isScramble(s1, s2, 0,0,len,attach);			
		} else {
			return false;
		}
	}

    public boolean isScramble(String s1, String s2, int i1, int i2, int len, int[][][] attach){
    	if(attach[i1][i2][len-1] != UNSET)
    		return attach[i1][i2][len-1] == TRUE;
    	boolean result = false;
    	if(len == 1){
    		if(s1.charAt(i1) == s2.charAt(i2)){
    			result = true;
    		}
    	} else {
    		for(int i = 1; i < len; i++){
    			if(
    					(
    							isScramble(s1, s2, i1, i2, i, attach)
    							&& isScramble(s1, s2, i1+i, i2+i, len-i, attach)
    					) || (
    							isScramble(s1, s2, i1, i2+len-i, i, attach)
    							&& isScramble(s1, s2, i1+i, i2, len-i, attach)
    					)
    			){
    				result = true;
    				break;
    			}
    		}
    	}
    	attach[i1][i2][len-1] = result? TRUE:FALSE;
    	return result;
    }
    
    
    public static void main(String args[]){
    	String s1 = "abcdefghijklmnopq";
    	String s2 = "efghijklmnopqcadb";
    	ScrambleString ss = new ScrambleString();
    	System.out.println(ss.isScramble(s1, s2));
    }
}
