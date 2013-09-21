import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] romanVals = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        Map<Integer, String> romanChars = new HashMap<Integer, String>();
        romanChars.put(1, "I");
        romanChars.put(4, "IV");
        romanChars.put(5, "V");
        romanChars.put(9, "IX");
        romanChars.put(10, "X");
        romanChars.put(40, "XL");
        romanChars.put(50, "L");
        romanChars.put(90, "XC");
        romanChars.put(100, "C");
        romanChars.put(400, "CD");
        romanChars.put(500, "D");
        romanChars.put(900, "CM");
        romanChars.put(1000, "M");
        StringBuilder sb = new StringBuilder();
        while(num > 0){
        	for(int i = romanVals.length-1; i >=0; i--){
        		while(num >= romanVals[i]){
        			sb.append(romanChars.get(romanVals[i]));
        			num -= romanVals[i];
        		}
        	}
        }
        return sb.toString();
    }
    
   @Test
   public void test(){
	   int num = 3999;
	   System.out.println(intToRoman(num));
   }
}
