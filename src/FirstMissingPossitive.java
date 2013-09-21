import org.junit.Test;


public class FirstMissingPossitive {
    public int firstMissingPositive(int[] A) {
        
        int len = A.length;
        if(len == 0)
        	return 1;
        for(int i = 0; i < len; i++){
            while(A[i] > 0 && A[i]-1 != i){
            	if(A[i] < len && A[A[i]-1] != A[i])
            		swap(A, i, A[i]-1);
            	else
            		break;
            }
        }
        
        for(int i = 0; i < len; i++){
        	if(A[i] != i+1 ){
        		return i+1;
        	}
        }
        
        return len+1;
    }
    
    private void swap(int[] A, int i, int j){
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
    
    @Test
    public void test(){
    	int[] A = new int[]{2};
    	System.out.println(this.firstMissingPositive(A));
    }
}
