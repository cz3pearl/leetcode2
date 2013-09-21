
public class DecodeWays {
    public int numDecodings(String s) {
        return numDecoding(s);
    }
    
    private int numDecoding(String s){
    	int len = s.length();
    	if(len == 0)
    		return 0;
    	if(len == 1){
    		int c = s.charAt(0);
    		if(c != '0')
    			return 1;
    		else
    			return 0;
    	} else {
    		
    		int[] nums = new int[s.length()+1];
    		nums[len] = 1;
    		int eC = s.charAt(len-1);
    		if(eC != '0'){
    			nums[len-1] = 1;
    		} else {
    			nums[len-1] = 0;
    		}
    		for(int i = len-2; i>=0 ; i--){
    			int c = s.charAt(i);
    			if(c != '0'){
	    			if(Integer.parseInt(s.substring(i, i+2)) < 27){
	    				nums[i] = nums[i+1]+nums[i+2];
	    			} else {
	    				nums[i] = nums[i+1];
	    			}
    			} else {
    				nums[i] = 0;
    			}
    		}
    		return nums[0];
    	}
    }
    
    public static void main(String args[]){
    	String s = "1115";
    	System.out.println(new DecodeWays().numDecodings(s));
    }
}
