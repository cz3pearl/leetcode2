import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;


public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int n : S){
            nums.add(n);
        }
        Collections.sort(nums);
        return subsets(nums, 0, S.length);
    }
    
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S, int n, int len){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(n == len -1){
            ArrayList<Integer> line = new ArrayList<Integer>();
            line.add(S.get(n));
            ArrayList<Integer> empty = new ArrayList<Integer>();
            result.add(line);
            result.add(empty);
        } else {
            ArrayList<ArrayList<Integer>> sub = subsets(S, n+1, len);
            result.addAll(sub);
            for(ArrayList<Integer> line : sub){
                ArrayList<Integer> clone = (ArrayList<Integer>)line.clone();
                clone.add(0,S.get(n));
                result.add(clone);
            }
        }
        return result;
    }
    
    @Test
    public void test(){
    	int[] array = new int[]{0};
    	System.out.println(subsets(array));
    }
}
