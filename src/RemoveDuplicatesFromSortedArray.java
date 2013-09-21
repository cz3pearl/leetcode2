import org.junit.Test;


public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        int len = A.length;
    	if(len > 0){
    		int rlen = 1;
    		int lastVal = A[0];
    		for(int i = 1; i < len; i++){
    			if(A[i] != lastVal){
    				A[rlen++] = A[i];
    				lastVal = A[i];
    			}
    		}
    		return rlen;
    	} else {
    		return 0;
    	} 	
    }
    
    @Test
    public void testRemoveDup(){
    	int[] array = new int[]{1,1};
    	System.out.println(removeDuplicates(array) + "," + Util.intArrayStr(array));
    }
}
