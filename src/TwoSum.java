
public class TwoSum {
	
    public int[] twoSum(int[] numbers, int target) {
    	int len = numbers.length;
    	for(int i = 0; i < len; i++){
    		for(int j = i+1; j < len; j++){
    			if(target == (numbers[i] + numbers[j])){
                    return new int[]{i+1, j+1};                    
    			}
    		}
    	}
        return new int[]{0,0};
    }
	
}
