
public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = prices.length;
        int totalProf = 0;
        if(len > 1){
        	for(int i = 1; i < len; i++){
        		int change = prices[i] - prices[i-1];
        		if(change > 0){
        			totalProf +=change;
        		}
        	}
        }
        return totalProf;
    }
	
}
