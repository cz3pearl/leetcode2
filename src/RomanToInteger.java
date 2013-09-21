import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int len = s.length();
        if(len == 1)
        	return map.get(s.charAt(0));
        int num = 0;
        for(int i = 0; i < len -1; i++){
        	if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
        		num -=map.get(s.charAt(i));
        	} else {
        		num +=map.get(s.charAt(i));
        	}
        }
        num +=map.get(s.charAt(len-1));
        return num;
    }
    
    @Test
    public void test(){
    	String s = "II";
    	System.out.println(romanToInt(s));
    }
}
