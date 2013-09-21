import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;


public class MinimumWindowSubtring {

//    public String minWindow(String S, String T) {
//    	if(T.length() == 0)
//    		return "";
//    	Set<Character> cSet = new HashSet<Character>();
//    	for(char c : T.toCharArray()){
//    		cSet.add(c);
//    	}
//    	int len = S.length();
//    	Map<Character, Integer> map = new HashMap<Character, Integer>();
//    	MinMax min = null;
//    	for(int i = 0; i < len; i++){
//    		Character c = S.charAt(i);
//    		if(cSet.contains(c)){
//    			map.put(c, i);
//    			if(map.size() == cSet.size()){
//    				MinMax minMax = findMaxMinGap(map);
//    				if(null == min){
//    					min = minMax;
//    				} else {
//    					if(min.gap() > minMax.gap()){
//    						min = minMax;
//    					}
//    				}
//    			}
//    		}
//    	}
//    	if(null != min)
//    		return S.substring(min.min, min.max+1);
//    	else
//    		return "";
//    }
//    public MinMax findMaxMinGap(Map<Character, Integer> map){
//    	Integer min = null;
//    	Integer max = null;
//    	for(Entry<Character, Integer> entry : map.entrySet()){
//    		Integer val = entry.getValue();
//    		if(null == min){
//    			 min = val;
//    		} else {
//    			min = Math.min(min, val);
//    		}
//    		if(null == max){
//    			max = val;
//    		} else {
//    			max = Math.max(max, val);
//    		}
//    	}
//    	return new MinMax(min, max);
//    }
	
    private static class MinMax{
    	int max;
    	int min;
    	public MinMax(int min, int max){
    		this.min = min;
    		this.max = max;
    	}
    	
    	public int gap(){
    		return max - min;
    	}
    }
    
    public static class CharCounter{
    	Map<Character, Integer> charCountMap;
    	int count;
    	int len;
    	Map<Character, LinkedList<Integer>> charListMap;
    	public CharCounter(Map<Character,Integer> charCountMap, int len){
    		this.charCountMap = charCountMap;
    		this.len = len;
    		this.count = 0;
    		this.charListMap = new HashMap<Character, LinkedList<Integer>>();
    	}
    	
    	public boolean addChar(char c, int idx){
    		Integer charLimit = charCountMap.get(c);
    		if(null != charLimit){
    			LinkedList<Integer> list = charListMap.get(c);
    			if(null == list){
    				list = new LinkedList<Integer>();
    				list.add(idx);
    				charListMap.put(c, list);
    				count++;
    			} else {
    				if (charLimit > list.size()){
    					list.add(idx);
    					count++;
    				} else {
    					list.removeFirst();
    					list.add(idx);
    				}
    			}
    			return true;
    		} else {
    			return false;
    		}
    	}
    	
    	public boolean isFull(){
    		return count == len;
    	}
    	
    	private Integer getCharMin(char c){
    		LinkedList<Integer> list = charListMap.get(c);
    		if(null != list){
    			return list.get(0);
    		} else {
    			return null;
    		}
    	}
    	
    	private Integer getCharMax(char c){
    		LinkedList<Integer> list = charListMap.get(c);
    		if(null != list){
    			return list.get(list.size()-1);
    		} else {
    			return null;
    		}
    	}
    	
    	public MinMax findMinMax(){
    		if(isFull()){
    			Integer min = null;
    			Integer max = null;
    			for(Entry<Character, Integer> entry : charCountMap.entrySet()){
    				Character c = entry.getKey();
    				if(null == min){
    					min = getCharMin(c);
    				} else {
    					min = Math.min(min, getCharMin(c));
    				}
    				if(null == max){
    					max = getCharMax(c);
    				} else {
    					max = Math.max(max, getCharMax(c));
    				}
    			}
    			if(null != min && null != max){
    				return new MinMax(min, max);
    			} else {
    				return null;
    			}
    		} else {
    			return null;
    		}
    	}
    }
    
    public String minWindow(String S, String T) {
    	if(T.length() == 0)
    		return "";
    	Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
    	for(Character c : T.toCharArray()){
    		if(charCountMap.containsKey(c)){
    			charCountMap.put(c, charCountMap.get(c)+1);
    		} else {
    			charCountMap.put(c, 1);
    		}
    	}
    	
    	CharCounter cc = new CharCounter(charCountMap, T.length());
    	MinMax minMax = null;
    	for(int i = 0; i < S.length(); i++){
    		cc.addChar(S.charAt(i), i);
    		if(cc.isFull()){
    			MinMax cMinMax = cc.findMinMax();
    			if(null == minMax){
    				minMax = cMinMax;
    			} else {
    				if(cMinMax.gap() < minMax.gap()){
    					minMax = cMinMax;
    				}
    			}
    		}
    	}
    	
    	if(null == minMax)
    		return "";
    	else 
    		return S.substring(minMax.min, minMax.max+1);
    }
    @Test
    public void test(){
    	String S = "aaab";
    	String T = "aba";
    	System.out.println(minWindow(S, T));
    }
}
