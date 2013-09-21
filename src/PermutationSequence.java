import org.junit.Test;


public class PermutationSequence {
    public String getPermutation(int n, int k) {
    	boolean[] flags = new boolean[n+1];
    	int[] helper = new int[n+1];
    	int g = 1;
    	for(int i = 1; i <= n; i++){
    		flags[i] = true;
    		g*=i;
    		helper[i] = g;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	int left = n;
    	while( left > 1){
    		int idx = (k-1)/helper[left-1] + 1;
    		int v = findN(flags, idx);
    		flags[v] = false;
    		sb.append(v);
    		k = (k-1)%helper[left-1] + 1;
    		left--;
    	}
    	int last = findN(flags, 1);
    	flags[last] = false;
    	sb.append(last);
    	return sb.toString();
    }
    
    private int findN(boolean[] flags, int n){
    	int left = n;
    	for(int i= 1; i < flags.length; i++){
    		if(flags[i]){
    			left--;
    			if(left == 0){
    				return i;
    			}
    		}
    	}
    	return -1;
    }
    
    @Test
    public void test(){
    	for(int i = 1; i <=6; i++){
    		System.out.println(getPermutation(3,i));
    	}
    }
}
