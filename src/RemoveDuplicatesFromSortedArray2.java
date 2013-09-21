import org.junit.Test;


public class RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] A) {
        int len = A.length;
        if(len == 0){
        	return 0;
        } else {
        	int limit = 2;
            int curLimit = 1;
            int lastVal = A[0];
            int rLen = 1;
            for(int i = 1; i < len; i++){
            	if(lastVal == A[i]){
            		if(curLimit++ < limit){
            			A[rLen++] = A[i];
            		} 
            	} else {
            		A[rLen++] = A[i];
            		lastVal = A[i];
            		curLimit = 1;
            	}
            }
            return rLen;       	
        }
    }
    
    @Test
    public void testRemoveDuplicates(){
    	int[] array = new int[]{1,1,1,2,3,3,3};
    	System.out.println(removeDuplicates(array) + "," + Util.intArrayStr(array));
    }
}
