import java.util.ArrayList;


public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
    	int pow = (int)Math.pow(2, n-1);
    	return grayCode(n, pow);
    }
    
    public ArrayList<Integer> grayCode(int n, int pow){
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(0 == n){
    		result.add(0);
    	} else {
    		ArrayList<Integer> subRet = grayCode(n-1, pow/2);
    		int size = subRet.size();
    		for(int i = 0; i < size; i++){
    			result.add(subRet.get(i));
    		}
    		for(int i = size-1; i>=0; i--){
    			result.add(pow + subRet.get(i));
    		}
    	}
    	return result;
    }
    
    public static void main(String args[]){
    	int n = 0;
    	System.out.println(new GrayCode().grayCode(n));
    }
}
