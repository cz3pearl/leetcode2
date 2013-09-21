import java.util.HashMap;

import org.junit.Test;


public class LongestSubStringWithOutRepeatCharacter {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int len = s.length();
        int i = 0;
        int start = 0;
        int max = 0;
        while(i < len){
        	char c = s.charAt(i);
        	if(map.containsKey(c)){
        		int lastCIdx = map.get(c);
        		remove(map, s, start, lastCIdx);
        		start = lastCIdx+1;
        	} 
        	map.put(c, i);
        	max = Math.max(map.size(), max);
        	i++;
        }
        return max;        
    }
    
    private void remove(HashMap<Character, Integer> map, String s, int idxStart, int idxEnd){
    	for(int i = idxStart; i <= idxEnd; i++){
    		map.remove(s.charAt(i));
    	}
    }
    
    @Test
    public void test(){
    	System.out.println(lengthOfLongestSubstring("abcde"));
    	System.out.println(lengthOfLongestSubstring("aaaaa"));
    }
}
