import java.util.ArrayList;


public class MergeSortedArray {
	
    public void merge(int A[], int m, int B[], int n) {
    	ArrayList<Integer> list = new ArrayList<Integer>(m+n);
    	int iA = 0;
    	int iB = 0;
    	while(iA < m && iB < n){
    		if(A[iA] < B[iB]){
    			list.add(A[iA]);
    			iA++;
    		} else {
    			list.add(B[iB]);
    			iB++;
    		}
    	}
        
    	if(iA < m){
    		for(int i = iA; i < m; i++){
    			list.add(A[i]);
    		}
    	}
    	if(iB < n){
    		for(int i = iB; i < n; i++){
    			list.add(B[i]);
    		}
    	}
    	
    	for(int i = 0; i < m+n; i++){
    		A[i] = list.get(i);
    	}
    }
    
    public static void main(String args[]){
    	int m = 7;
    	int n = 3;
    	int[] A = new int[]{1,2,3,4,5,6,7,0,0,0};
    	int[] B = new int[]{8,9,10};
    	MergeSortedArray msa = new MergeSortedArray();
    	msa.merge(A, m, B, n);
    	for(int i : A){
    		System.out.print(i);
    	}
    }

}
