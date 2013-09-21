
public class InterLeavingString {
	private static final int UNSET = -1;
	private static final int TRUE = 0;
	private static final int FALSE = 1;
    public boolean isInterleave(String s1, String s2, String s3) {
    	int len1 = s1.length();
    	int len2 = s2.length();
    	int len3 = s3.length();
    	if((len1 + len2) == len3){
    		if(len1 > 0 && len2 > 0){
    			int[][] flag = new int[len1][len2];
    			for(int i = 0; i < len1; i++){
    				for(int j = 0; j < len2; j++){
    					flag[i][j] = UNSET;
    				}
    			}
    			return check(s1, s2, s3, flag);
    		} else {
    			return s1.equals(s3) || s2.equals(s3);
    		}
    	} else {
    		return false;
    	}
    }
    
    private boolean check(String s1, String s2, String s3, int[][] flag){
    	int len1 = s1.length() - 1;
    	int len2 = s2.length() - 1;
    	if(UNSET == flag[len1][len2]){
	    	char c = s3.charAt(0);
	    	boolean check1 = false;
	    	boolean check2 = false;
	    	if(len1 >= 0){
	    		if(len1 == 0){
	    			check1 = (c == s1.charAt(0)) && s3.substring(1).equals(s2);
	    		} else if(c == s1.charAt(0)){
	    			check1 = check(s1.substring(1), s2, s3.substring(1), flag);
	    		}
	    	}
	    	if(len2 >= 0){
	    		if(len2 == 0){
	    			check2 = (c == s2.charAt(0)) && s3.substring(1).equals(s1);
	    		} else if(c == s2.charAt(0)){
		    		check2 = check(s1, s2.substring(1), s3.substring(1), flag);
		    	}
	    	}
	    	if(check1 || check2){
	    		flag[len1][len2] = TRUE;
	    	} else {
	    		flag[len1][len2] = FALSE;
	    	}
    	} 
    	return (TRUE == flag[len1][len2]);
    }
    public static void main(String args[]){
    	String[] strs = new String[]{"aabd", "abdc", "aabdbadc"};
    	String s1 = "ab";
    	String s2 = "bc";
    	String s3 = "babc";
    	InterLeavingString ils = new InterLeavingString();
    	System.out.println(ils.isInterleave(strs[0], strs[1], strs[2]));
    }
}
