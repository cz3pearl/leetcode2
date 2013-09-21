import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;


public class Anagrams {

    public ArrayList<String> anagrams(String[] strs) {
    	ArrayList<String> resultList = new ArrayList<String>();
        Map<String,ArrayList<String>> anagramMap = new HashMap<String,ArrayList<String>>();
        for(String s : strs){
        	String orderedString = getString(getSortedCharList(s));
        	ArrayList<String> list = anagramMap.get(orderedString);
        	if(null == list){
        		list = new ArrayList<String>();
        		anagramMap.put(orderedString, list);
        	}
        	list.add(s);
        }
        
        for(Entry<String,ArrayList<String>> entry : anagramMap.entrySet()){
        	ArrayList<String> value = entry.getValue();
        	if(null != value){
        		if(value.size() > 1){
        			resultList.addAll(value);
        		}
        	}
        }
        return resultList;
    }
    
    public ArrayList<Character> getSortedCharList(String s){
    	ArrayList<Character> charList = new ArrayList<Character>();
    	int len = s.length();
    	for(int i = 0; i < len; i++){
    		charList.add(s.charAt(i));
    	}
    	Collections.sort(charList);
    	return charList;
    }
    
    public String getString(ArrayList<Character> charList){
    	StringBuilder sb = new StringBuilder();
    	for(Character c : charList){
    		sb.append(c);
    	}
    	return sb.toString();
    }
    
    @Test
    public void test(){
    	String[] strs = new String[]{"","",""};
    	System.out.println(anagrams(strs));
    }
}
