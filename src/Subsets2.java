import java.util.ArrayList;
import java.util.Collections;


public class Subsets2 {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int n : num){
        	nums.add(n);
        }
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> subsets = subsets(nums, 0, nums.size());
        for(int i = 0; i < subsets.size(); i++){
        	ArrayList<Integer> iList = subsets.get(i);
        	for(int j=i+1; j < subsets.size(); j++){
        		ArrayList<Integer> jList = subsets.get(j);
        		if(isEqual(iList,jList)){
        			subsets.remove(j);
        			j--;
        		}
        	}
        }
        return subsets;
    }
    
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> nums, int start, int size){
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(start < size){
    		if(start == size-1){
    			ArrayList<Integer> line = new ArrayList<Integer>();
    			line.add(nums.get(start));
    			result.add(line);
    			result.add(new ArrayList<Integer>());
    		} else {
    			ArrayList<Integer> line = new ArrayList<Integer>();
    			line.add(nums.get(start));
    			ArrayList<ArrayList<Integer>> subRet = subsets(nums, start+1, size);
    			for(ArrayList<Integer> oneSub : subRet){
    				ArrayList<Integer> cLine = (ArrayList<Integer>)line.clone();
    				cLine.addAll(oneSub);
    				result.add(cLine);
    			}
    			result.addAll(subRet);
    		}
    	}
    	return result;    	
    }
    
    
    private boolean isEqual(ArrayList<Integer> list1, ArrayList<Integer> list2){
    	int size1 = list1.size();
    	int size2 = list2.size();
    	if(size1 == size2){
    		for(int i = 0; i < size1; i++){
    			if(!list1.get(i).equals(list2.get(i))){
    				return false;
    			}
    		}
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public static void main(String args[]){
    	int[] num = new int[]{0};
    	Subsets2 ss2 = new Subsets2();
    	System.out.println(ss2.subsetsWithDup(num));
    }
}
