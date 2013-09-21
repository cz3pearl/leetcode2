
public class ClimbingStairs {

	
    public int climbStairs(int n) {
    	if(1 == n)
    		return 1;
    	if(2 == n)
    		return 2;
    	int[] attach = new int[n];
    	attach[0] = 1;
    	attach[1] = 2;
    	for(int i = 3; i <= n; i++){
    		attach[i-1] = attach[i-2] + attach[i-3];
    	}
    	return attach[n-1];
    }
    
    
}
