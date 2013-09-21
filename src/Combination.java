import java.util.ArrayList;

import org.junit.Test;


public class Combination {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        return combine(1, n, k);
    }
    
    
    public ArrayList<ArrayList<Integer>> combine(int start, int end, int k){
    	int gap = end - start + 1;
    	if(gap < k|| k <0 ){
    		return null;
    	} else {
    		
    		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    		if( k == 0){
    			ArrayList<Integer> line = new ArrayList<Integer>();
        		result.add(line);
    		} else {
				ArrayList<ArrayList<Integer>> subMinu = combine(start+1, end, k-1);
			
	    		if(null != subMinu){
	    			for(ArrayList<Integer> line : subMinu){
	    				line.add(0, start);
	    			}
	    			result.addAll(subMinu);
	    		}
	    		ArrayList<ArrayList<Integer>> subAll = combine(start+1, end, k);
	    		if(null != subAll){
	    			result.addAll(subAll);
	    		}
    		}
    		
    		return result;
    	}
    }
    
    @Test
    public void test(){
    	System.out.println(combine(4, 2));
    }
}
