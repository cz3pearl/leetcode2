
public class BestTimeToBuyAndSellStock3 {

	
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int len = prices.length;
    	Ret ret= maxProf(prices, 0, len);
    	Ret retHead = maxProf(prices, 0, ret.start);
    	Ret retEnd = maxProf(prices, ret.end, len);
    	int maxCost = maxCost(prices, ret.start, ret.end);
    	int secondMax = Math.max(retHead.maxResult, retEnd.maxResult);
    	if( (secondMax + maxCost) > 0){
    		return ret.maxResult + secondMax;
    	} else {
    		return ret.maxResult - maxCost;
    	}
    }
    
    
    public Ret maxProf(int[] prices, int start, int end) {
    	int maxProf = 0;
    	int tStart = start;
    	int tEnd = start;
    	int len = end - start;
    	if(len > 1){
    		int curMax = 0;
    		int curStart = 0;
    		for(int i = start + 1; i < end; i++){
    			int change = prices[i]-prices[i-1];
    			curMax += change;
    			if(maxProf < curMax){
    				maxProf = curMax;
    				tStart = curStart;
    				tEnd = i+1;
    			} 
    			if(curMax < 0){
    				curMax = 0;
    				curStart = i;
    			}
    		}
    	}
    	Ret ret = new Ret();
    	ret.maxResult = maxProf;
    	ret.start = tStart;
    	ret.end = tEnd;
//    	System.out.println("start:"+start+", end:"+end+"\n"
//    			+"ret.start:"+tStart+", ret.end:"+tEnd+", maxResult:"+maxProf);
    	return ret;
    }
  
    
    public int maxCost(int[] prices, int start, int end){
    	int maxCost = 0;
    	int curMaxCost = 0;
    	for(int i = start+1; i < end; i++){
    		int change = prices[i]-prices[i-1];
    		if(change <= 0){
    			curMaxCost +=change;
    			if(curMaxCost < maxCost){
    				maxCost = curMaxCost;
    			}
    		} else{
    			curMaxCost = 0;
    		}
    	}
    	
    	return maxCost;
    }
        
    public static class Ret {
    	public int start;
    	public int end;
    	public int maxResult;
    }
    
    public static void main(String args[]){
    	int[] prices = new int[]{6,1,3,2,4,7};
    	
    	System.out.println(new BestTimeToBuyAndSellStock3().maxProfit(prices));
    }
	
}
