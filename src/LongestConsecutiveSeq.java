import java.util.HashMap;
import java.util.Map;


public class LongestConsecutiveSeq {

    public int longestConsecutive(int[] num) {
        return longestCount(num);
    }
    
    private static class Pair{
    	int max;
    	int min;
    	int c = 1;
    	public Pair(int min, int max){
    		this.max = max;
    		this.min = min;
    	}
    	public Pair(int val){
    		this.max = val;
    		this.min = val;
    	}
    }
    
    public int longestCount(int[] num){
    	Map<Integer,Pair> valMap = new HashMap<Integer,Pair>();
    	if(0 == num.length)
    		return 0;
    	int max = 0;
    	for(int i = 0; i < num.length; i++){
    		int v = num[i];
    		Pair op = valMap.get(v);
    		if(null == op){
    			valMap.put(v, new Pair(v));
	    		Pair ret = mergeLeft(valMap, v);
	    		while(null != ret){
	    			if( (ret.max - ret.min) > max)
	    				max = ret.max - ret.min;
	    			ret = mergeLeft(valMap, ret.min);
	    		}
	    		
	    		ret = mergeRight(valMap, v);
	    		while(null != ret){
	    			if( (ret.max - ret.min) > max)
	    				max = ret.max - ret.min;
	    			ret = mergeRight(valMap, ret.max);
	    		}
    		}
    	}
    	return max+1;
    }
    
    private Pair mergeLeft(Map<Integer,Pair> valMap, int v){
    	Pair lp = valMap.get(v-1);
    	if(null != lp){
    		Pair vp = valMap.get(v);
			lp.max = vp.max;
			lp.c+=vp.c;
			for(int i = vp.min; i<= vp.max; i++){
				valMap.put(v, lp);
			}
    		return lp;
    	}
    	return null;   	
    }
    private Pair mergeRight(Map<Integer,Pair> valMap, int v){
    	Pair rp = valMap.get(v+1);
    	if(null != rp){
    		Pair vp = valMap.get(v);
			rp.min = vp.min;
			rp.c+=vp.c;
			for(int i = vp.min; i <=vp.max; i++){
				valMap.put(i, rp);
			}
    		return rp;
    	}
    	return null;    	
    }
    
    public static void main(String args[]){
    	int[] num = new int[]{0};
    	LongestConsecutiveSeq lcs = new LongestConsecutiveSeq();
    	System.out.println(lcs.longestConsecutive(num));
    }
}
