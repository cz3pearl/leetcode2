import java.util.ArrayList;

import org.junit.Test;


public class ZigZagConversion {

    public String convert(String s, int nRows) {
    	if(nRows == 1)
    		return s;
        boolean isDown = true;
        ArrayList<StringBuilder> sbList = new ArrayList<StringBuilder>();
        for(int i = 0; i < nRows; i++){
        	sbList.add(new StringBuilder());
        }
        int idx = 0;
        for(char c : s.toCharArray()){
        	sbList.get(idx).append(c);
        	if( (isDown && idx == (nRows-1)) || ((!isDown) && (idx == 0))){
        		isDown = !isDown;
        	}
        	if(isDown){
        		idx++;
        	} else {
        		idx--;
        	}
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder tSb : sbList){
        	sb.append(tSb);
        }
        return sb.toString();
    }
    
    
    @Test
    public void test(){
    	String orig = "AB";
    	String expect = "1";
    	System.out.println(expect.equals(convert(orig, 3)));
    }
	
}
