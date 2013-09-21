import org.junit.Test;


public class CountAndSay {

    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder origSb = new StringBuilder("1");
        for(int i = 1; i < n; i++){
        	origSb = countAndSay(origSb);
        }
        return origSb.toString();
    }
    
    public StringBuilder countAndSay(StringBuilder sb){
    	int len = sb.length();
    	char c = sb.charAt(0);
    	int count = 1;
    	StringBuilder nsb = new StringBuilder();
    	for(int i = 1; i < len; i++){
    		if(sb.charAt(i) == c){
    			count++;
    		} else {
    			nsb.append(count+""+c);
    			c = sb.charAt(i);
    			count = 1;
    		}
    	}
    	
    	nsb.append(count+""+c);
    	return nsb;
    }
	
    
    @Test
    public void test(){
    	for(int i = 1; i < 10; i++){
    		System.out.println(countAndSay(i));
    	}
    }
}
