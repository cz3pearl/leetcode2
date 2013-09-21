import java.util.ArrayList;
import java.util.Map;


public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    }
    
    public ArrayList<ArrayList<Integer>> combinationSum(Map<IntegerPair, ArrayList<ArrayList<Integer>>> map, int[] candidates, int idx, int target){
    	IntegerPair key = new IntegerPair(idx, target);
    	if(map.containsKey(key)){
    		return map.get(key);
    	} else {
    		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    		for(int i = idx; i < candidates.length; i++){
    			int cV = candidates[i];
    			int totalTimes = target/cV;
    			if(totalTimes > 0){
    				for(int k = 0; k < totalTimes; k++){
    					ArrayList<Integer> tList = new ArrayList<Integer>();
    					
    				}
    			}
    		}
    	}
    }
    
    private void addToList(ArrayList<Integer> list, Integer v, Integer times){
    	while(times-- > 0){
    		list.add(v);
    	}
    }
    
    public static class IntegerPair{
    	Integer u;
    	Integer v;
    	public IntegerPair(Integer u, Integer v){
    		this.u = u;
    		this.v = v;
    	}
    	
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((u == null) ? 0 : u.hashCode());
			result = prime * result + ((v == null) ? 0 : v.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			IntegerPair other = (IntegerPair) obj;
			if (u == null) {
				if (other.u != null)
					return false;
			} else if (!u.equals(other.u))
				return false;
			if (v == null) {
				if (other.v != null)
					return false;
			} else if (!v.equals(other.v))
				return false;
			return true;
		}
    }
}
