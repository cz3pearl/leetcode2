import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Permutaions2 {

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	ArrayList<ArrayList<Integer>> result = permute(num);
    	Set<Integer> set = new HashSet<Integer>();
    	for(int i = 0; i < result.size(); i++){
    		Integer str = getInt(result.get(i));
    		if(set.contains(str)){
    			result.remove(i);
    			i--;
    		}else{
    			set.add(str);
    		}
    	}
    	return result;
    }
    
    private int getInt(ArrayList<Integer> list){
    	int v = 0;
    	int t = 1;
    	for(Integer i : list){
    		v+=t*i;
    		t*=10;
    	}
    	return v;
    }
    
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
}
