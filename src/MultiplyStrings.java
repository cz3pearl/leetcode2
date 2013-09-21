import org.junit.Test;


public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] iNum1 = getNumArray(num1);
        int[] iNum2 = getNumArray(num2);
        int[] iRet = multiply(iNum1, iNum2);
        return getNumString(iRet);
    }
    
    private String getNumString(int[] num){
    	int len = num.length;
    	int validCount = len;
    	for(int i = len-1; i >=1; i--){
    		if(num[i] != 0)
    			break;
    		validCount--;
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int i = validCount-1; i>=0; i--){
    		sb.append(num[i]);
    	}
    	return sb.toString();
    }
    
    private int[] getNumArray(String numStr){
    	int len = numStr.length();
    	int[] num = new int[len];
    	for(int i = 0; i < len; i++){
        	num[i] = numStr.charAt(len-1-i)-'0';
        }
    	return num;
    }
    
    public int[] multiply(int[] num1, int[] num2){
    	int len1 = num1.length;
    	int len2 = num2.length;
    	int total = len1+len2+1;
    	int[] result = new int[total];
    	for(int i = 0; i < total; i++){
    		result[i] = 0;
    	}
    	for(int i = 0; i < len1; i++){
    		for(int j = 0; j < len2; j++){
    			int t = num1[i]*num2[j]+result[i+j];
    			result[i+j] = t%10;
    			result[i+j+1] += t/10;
    		}
    	}
    	return result;
    }
    
    @Test
    public void test(){
    	long num1 = 569871231;
    	long num2 = 123234098;
    	String result1 = num1*num2 + "";
    	String testResult = multiply(num1+"",num2+"");
    	System.out.println(result1.equals(testResult));
    	System.out.println(result1);
    	System.out.println(testResult);
    }
}
