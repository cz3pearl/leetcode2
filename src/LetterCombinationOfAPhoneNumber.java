import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;


public class LetterCombinationOfAPhoneNumber {

	private static final HashMap<Character, char[]> map = new HashMap<Character,char[]>();
	static{
		map.put('2', "abc".toCharArray());
		map.put('3', "def".toCharArray());
		map.put('4', "ghi".toCharArray());
		map.put('5', "jkl".toCharArray());
		map.put('6', "mno".toCharArray());
		map.put('7', "pqrs".toCharArray());
		map.put('8', "tuv".toCharArray());
		map.put('9', "wxyz".toCharArray());
	}
	
    public ArrayList<String> letterCombinations(String digits) {
    	
        ArrayList<String> result = new ArrayList<String>();
        int len = digits.length();
        if(0 == len){
        	result.add("");
        	return result;
        }
        if(len == 1){
        	Character fc = digits.charAt(0);
        	char[] ca = map.get(fc);
        	for(Character c: ca){
        		result.add(c+"");
        	}
        } else {
        	ArrayList<String> subResult = letterCombinations(digits.substring(1));
        	Character fc = digits.charAt(0);
        	char[] ca = map.get(fc);
        	for(Character c: ca){
        		for(String str : subResult){
        			result.add(c+str);
        		}
        	}
        }
        return result;
    }
    
    @Test
    public void test(){
    	for(String str : letterCombinations("23")){
    		System.out.println(str);
    	}
    }
}
