import org.junit.Test;


public class ReverseInteger {
    public int reverse(int x) {
    	int result = 0;
    	boolean isNeg = false;
    	if(x < 0) {
    		isNeg = true;
    	}
    	x = Math.abs(x);
    	while(x > 0){
    		int v = x%10;
    		x/=10;
    		result*=10;
    		result+=v;
    	}
    	return isNeg?-result:result;
    }
    
    @Test
    public void test(){
    	System.out.println(reverse(-85293));
    }

}
