import org.junit.Test;


public class PlusOne {
    public int[] plusOne(int[] digits) {
        int val = 1;
        
        int len = digits.length;
        digits[len-1]+=val;
        for(int i  = len-1; i >0; i--){
        	if(digits[i] >=10){
        		digits[i-1] += digits[i]/10;
        		digits[i] = digits[i]%10;
        	}
        }
        int more = 0;
        int test = digits[0];
        while(test > 9){
        	more++;
        	test = test/10;
        }
        int[] result = new int[len+more];
        for(int i = more + len - 1; i >= more; i--){
        	result[i] = digits[i-more];
        }
        
        int mul = 10;
        int div = 1;
        for(int i = 0; i <= more; i++){
        	result[more - i] = (digits[0]%mul)/div;
        	mul*=10;
        	div*=10;
        }
        return result;
    }
    
    @Test
    public void test(){
    	int[] digits = new int[]{9,9,9,9};
    	System.out.println(Util.intArrayStr(plusOne(digits)));
    }
}
