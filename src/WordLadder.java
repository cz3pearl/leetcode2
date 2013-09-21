import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class WordLadder {

    public int ladderLength(String start, String end, HashSet<String> dict) {
        int size = dict.size();
        String[] words = (String[]) dict.toArray();
        HashMap<String, Integer> posMap = new HashMap<String,Integer>();
        for(int i = 0; i < size; i++){
        	posMap.put(words[i], i);
        }
        //place to store dist of word i, j
        int[][] dist = new int[size][size];
        //init dist
        for(int i = 0; i < size; i++){
        	for(int j = 0; j < size; j++){
        		if(i != j)
        			dist[i][j] = Integer.MAX_VALUE;
        		else
        			dist[i][j] = 0;
        	}
        }
        
        for(int i = 0; i < size; i++){
        	for(int j = i+1; j < size; j++){
        		if(dist(words[i], words[j]) == 1){
        			dist[i][j] = 1;
        			dist[j][i] = 1;
        		}
        	}
        }
        HashSet<Integer> leftSet = new HashSet<Integer>();
        for(int i = 0; i < size; i++){
        	leftSet.add(i);
        }
        HashSet<Integer> calculatedSet = new HashSet<Integer>(); 
        int origPos = posMap.get(start);
        int endPos = posMap.get(end);
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(origPos);
        while(!queue.isEmpty()){
        	Integer wordIdx = queue.poll();
        	calculatedSet.add(wordIdx);
        	leftSet.remove(wordIdx);
        	for(int i = 0; i < size; i++){
        		if(dist[wordIdx][i] != Integer.MAX_VALUE){
        			
        			if(leftSet.contains(i)){
        				queue.add(i);
        			}
        		}
        	}
        }
        
        
    }
    
    private int dist(String a, String b){
    	if(a.length() == b.length()){
    		int len = a.length();
    		int diff = 0;
    		for(int i = 0; i < len; i++){
    			if(a.charAt(i) != b.charAt(i)){
    				diff++;
    			}
    		}
    		return diff;
    	} else {
    		return -1;
    	}
    }
}
