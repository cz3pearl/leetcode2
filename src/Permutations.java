import java.util.ArrayList;

import org.junit.Test;


public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        return permute(num, 0, num.length);
    }
    
    public ArrayList<ArrayList<Integer>> permute(int[] num, int start, int len){
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(len == 1){
    		ArrayList<Integer> line = new ArrayList<Integer>();
    		line.add(num[start]);
    		result.add(line);
    	} else {
    		ArrayList<ArrayList<Integer>> subResult = permute(num, start+1, len-1);
    		for(ArrayList<Integer> line : subResult){
    			for(int i = 0; i <= line.size(); i++){
    				ArrayList<Integer> copy = (ArrayList<Integer>) line.clone();
    				copy.add(i, num[start]);
    				result.add(copy);
    			}
    		}
    	}
    	return result;	
    }
    
    @Test
    public void test(){
    	int[] num = new int[]{1,2,3};
    	System.out.println(permute(num));
    }
}
