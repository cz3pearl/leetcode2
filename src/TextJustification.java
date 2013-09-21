import java.util.ArrayList;

import org.junit.Test;

public class TextJustification {

	
    public ArrayList<String> fullJustify(String[] words, int L) {
    	int idxStart = 0;
    	int lenCount = 0;
    	ArrayList<String> resultList = new ArrayList<String>();
        for(int i = 0; i < words.length; i++){
        	int test = lenCount;
        	if(i == idxStart)
        		test+=words[i].length();
        	else
        		test+=words[i].length() + 1;
        	if(test > L){
        		resultList.add(justifyString(words, idxStart, i, L));
        		idxStart = i;
        		lenCount = words[i].length();
        	} else {
        		lenCount = test;
        	}
        	
        }
        
        if(idxStart < words.length){
        	resultList.add(justifyString(words, idxStart, words.length, L));
        }
        
        return resultList;       
    }
    
    private String justifyString(String[] words, int idxStart, int idxEnd, int L){
    	StringBuilder sb = new StringBuilder();
    	if(idxEnd == words.length){
    		for(int i = idxStart; i< idxEnd;i++){
    			sb.append(words[i]);
    			if(i!=idxEnd-1){
    				sb.append(' ');
    			}
    		}
    		
    		while(sb.length() < L){
    			sb.append(' ');
    		}
    	} else {
	    	int wordsLen = 0;
	    	int wordCount = idxEnd - idxStart;
	    	for(int i = idxStart; i < idxEnd; i++){
	    		wordsLen +=words[i].length();
	    	}
	    	int left = L - wordsLen;
	    	int gap = left/(wordCount == 1? wordCount:wordCount-1);
	    	int addCount = wordCount == 1? 0: left%(wordCount-1);
	    	
	    	for(int i = idxStart; i < idxEnd; i++){
	    		sb.append(words[i]);
	    		if( (i == idxEnd -1 && i == idxStart) || (i != idxEnd -1)){
	    			for(int j = 0; j < gap; j++){
	    				sb.append(' ');
	    			}
	    			if((i - idxStart) < addCount){
	    				sb.append(' ');
	    			}
	    		}
	    	}
    	}
    	return sb.toString();
    }
    
    @Test
    public void test(){
    	String[] words = new String[]{"What","must","be","shall","be."};
    	int L = 12;
    	System.out.println(fullJustify(words, L));
    }
	
}
