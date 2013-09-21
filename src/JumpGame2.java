import org.junit.Test;


public class JumpGame2 {

	/*
	 * DP Solution
    public int jump(int[] A) {
        int len = A.length;
        int[] min = new int[len];
        min[len-1] = 0;
        for(int i = len-2; i >=0; i--){
        	int jumpLen = A[i];
        	int tMin = -1;
        	for(int j = 1; j <= jumpLen; j++){
        		int nextIdx = i+j;
        		if(nextIdx >= len){
        			break;
        		} else {
        			int nextV =  1+min[nextIdx];
        			if(min[nextIdx] >= 0)
        				tMin = tMin == -1?nextV:Math.min(tMin, 1+min[nextIdx]);
        		}
        	}
        	min[i] = tMin;
        }
        return min[0];
    }
    */
	
	//Greedy Solution
    public int jump(int[] A) {
		int len = A.length;
		if(len <= 1 )
			return 0;
		int currFar = 0;
		int i = 0;
		int minStep = 0;
		while(i < len - 1 ){
			currFar = i + A[i];
			minStep++;
			if(currFar >= len - 1)
				return minStep;
			int tmpFar = 0;
			for(int j = i+1; j <= currFar; j++){
                int v = j + A[j];
				if(v > tmpFar){
					tmpFar = v;
					i = j;
				}
			}
		}
		return -1;
	}
    
    @Test
    public void test(){
    	int[] array = new int[]{3,4,3,1,0,7,0,3,0,2,0,3};
    	System.out.println(jump(array));
    }
}
