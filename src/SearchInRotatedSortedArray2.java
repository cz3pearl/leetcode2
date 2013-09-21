
public class SearchInRotatedSortedArray2 {

    public boolean search(int[] A, int target) {
        int len = A.length;
        int L = 0;
        int R = len-1;
        while(L <= R){
            int M = (L+R)/2;
            if(target == A[M])
        		return true;
            if(A[L] == A[M]){
                L = L+1;
            } else if(A[L] < A[M]){//L -> M is sorted in ascending order
        		if(target >= A[L] && target < A[M]){ // in L -> M
        			R = M-1;
        		} else {
        			L = M+1;
        		}
        	} else { // M -> R is sorted in ascending order
        		if(target > A[M] && target <= A[R]){
        			L = M+1;
        		} else {
        			R = M-1;
        		}
        	}
        }
        return false;
    }
    
}
