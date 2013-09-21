import org.junit.Test;


public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
    	s = s.trim();
        int len = s.length();
    	int lastSpaceIdx = s.lastIndexOf(' ');
        if(lastSpaceIdx < 0){
        	return len;
        } else {
        	if(lastSpaceIdx == len - 1){
        		return 0;
        	} else {
        		return len - 1 - lastSpaceIdx;
        	}
        }
    }
    
    @Test
    public void test(){
    	String s = "Hello World";
    	System.out.println(lengthOfLastWord(s));
    }
}
