
public class BestTimeToBuyAndSellStock1 {

	
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
    	int maxProf = 0;
    	
    	int len = prices.length;
    	if(len > 1){
    		int curMax = 0;
    		for(int i = 1; i < len; i++){
    			int change = prices[i]-prices[i-1];
    			curMax += change;
    			if(maxProf < curMax){
    				maxProf = curMax;
    			} 
    			if(curMax < 0)
    				curMax = 0;
    		}
    	}
    	
    	return maxProf;
    }
	
    public static void main(String args[]){
    	
    	int[] prices = new int[]{1,2,-1,4,5};
    	System.out.println(new BestTimeToBuyAndSellStock1().maxProfit(prices));
    }
}
