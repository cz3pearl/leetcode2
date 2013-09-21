import org.junit.Test;


public class DivideTwoInteger {

    public int divide(int dividend, int divisor) {
        int c = -1;
        int flag = ((dividend>0 && divisor >0) || (dividend < 0 && divisor < 0))
        		? 1:-1;
        int tdividend = dividend > 0? -dividend: dividend;
        int tdivisor = divisor > 0? -divisor: divisor;
        int odivisor = tdivisor;
        
        // find min tdivisor<<c that larger than tdividend
        int test = tdivisor;
        while(tdividend <= test && test >= (-1<<31) && test < 0){
        	odivisor = test;
        	test = test<<1;
        	c++;
        }
        int ret = 0;
        
        if(c >=0){
        	while(tdividend <= tdivisor){
        		while(tdividend <= odivisor){
        			ret+=1<<c;
        			tdividend -=odivisor;
        		}
        		c--;
        		odivisor = odivisor>>1;
        	}
        }
        return flag > 0?ret:-ret;
    }
    
    @Test
    public void test(){
    	System.out.println(divide(2147483647, 2147483647));
    }
    
    public static void main(String args[]){
    	int v = -1;
    	System.out.println(v<<31);
    }
}
