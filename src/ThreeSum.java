import java.util.ArrayList;

import org.junit.Test;


public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        generateSumList(num, 0, 3, 0, curr, result);
        return result;
    }
    
    private void generateSumList(int[] num, int idx, int left, int sum, ArrayList<Integer> currList, ArrayList<ArrayList<Integer>> result){
    	if(left > 0){
	    	for(int i = idx; i< num.length; i++){
	    		if(i == idx || num[i] != num[i-1]){
		    		int testSum = sum+num[i];
		    		if(testSum == 0 && left == 1){
		    			ArrayList<Integer> line = (ArrayList<Integer>)currList.clone();
		    			line.add(num[i]);
		    			result.add(line);
		    		} else if (testSum <= 0 && (i == idx || num[i]!=num[i-1])){
		    			ArrayList<Integer> nextList = (ArrayList<Integer>) currList.clone();
		    			nextList.add(num[i]);
		    			generateSumList(num, i+1, left-1, testSum, nextList, result);
		    		}
	    		}
	    	}
    	}
    }
    
    private void sort(int[] num){
    	for(int i = 0; i < num.length; i++){
    		for(int j = num.length-1; j > i; j--){
    			if(num[j] < num[j-1]){
    				int t = num[j];
    				num[j] = num[j-1];
    				num[j-1] = t;
    			}
    		}
    	}
    }
    
    @Test
    public void test(){
    	int[] num = new int[]{0,0,0,0};
    	for(ArrayList<Integer> list : threeSum(num)){
    		System.out.println(list);
    	}
    }
}
