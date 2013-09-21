import org.junit.Test;


public class SortColors {
    public void sortColors(int[] A) {
        int len = A.length;
    	int i = 0;// 0 pointer
        int j = 0;// cursor 
        int k = len -1;//2 pointer
        
        while(j <= k){
        	if(A[j] == 0){
        		A[j] = A[i];
        		A[i] = 0;
        		i++;
        		j++;
        	} else if(A[j] == 2) {
        		A[j] = A[k];
        		A[k] = 2;
        		k--;
        	} else {
        		j++;
        	}
        }
    }
    
    @Test
    public void test(){
    	int[] A = new int[]{1,2,2,1,1,0,0,0,2,2,2};
    	sortColors(A);
    	System.out.println(Util.intArrayStr(A));
    }
}
