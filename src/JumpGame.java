import org.junit.Test;


public class JumpGame {
    public boolean canJump(int[] A) {
    	int len = A.length;
    	if(len == 0)
    		return true;
        boolean[] attach = new boolean[len];
        attach[len-1] = true;
        for(int i = len-2; i >=0; i--){
        	boolean nRet = false;
    		int times = A[i];
    		while(times > 0){
    			if(i + times < len){
    				nRet|=attach[i+times];
    			}
    			times--;
    		}
    		attach[i] = nRet;
        }
        return attach[0];
    }
    
    @Test
    public void test(){
    	int[] A = new int[]{2,3,1,1,4};
    	assert(canJump(A));
    	int[] B = new int[]{3,2,1,0,4};
    	assert(!canJump(B));
    }
}
