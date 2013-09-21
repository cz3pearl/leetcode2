import org.junit.Test;


public class AddBinary {

    public String addBinary(String a, String b) {
        return getString(verify(addArray(parseBinary(a), parseBinary(b)),2));        
    }
    
    public int[] parseBinary(String s){
    	int len = s.length();
    	int[] array = new int[s.length()];
    	for(int i = len-1; i >=0; i--){
    		array[len-1-i] =  '0' == s.charAt(i) ? 0:1;
    	}
    	return array;
    }
    
    public int[] addArray(int[] a, int b[]){
    	int len1 = a.length;
    	int len2 = b.length;
    	
    	int[] l;
    	int[] s;
    	if(len1 >=len2){
    		l = a;
    		s = b;
    	} else {
    		l = b;
    		s = a;
    	}
    	
    	int[] ret = new int[l.length];
    	for(int i = 0; i < s.length; i++){
    		ret[i] = l[i]+s[i];
    	}
    	
    	for(int i = s.length; i < l.length; i++){
    		ret[i] = l[i];
    	}
    	return ret;
    }
    
    
    public int[] verify(int[] a, int mod){
    	int len = a.length;
    	for(int i = 0; i < len-1; i++){
    		a[i+1] += a[i]/mod;
    		a[i] = a[i]%mod;
    	}
    	
    	int count = 0;
    	int test = a[len-1];
    	while(test >= mod){
    		count++;
    		test = test/mod;
    	}
    	
    	
    	int newLen = len + count;
    	int[] ret = new int[newLen];
    	for(int i = 0; i <= len-1; i++){
    		ret[i] = a[i];
    	}
    	int mul = mod;
    	int div = 1;
    	for(int i = 0; i < count; i++){
    		ret[len -1 + i] = (a[len-1]%mul)/div;
    		ret[len + i] = (a[len-1]/mul);
    		mul*=mod;
    		div*=mod;
    	}
    	return ret;
    }

    public String getString(int[] array){
    	StringBuilder sb = new StringBuilder();
    	int len = array.length;
    	for(int i = len-1; i >=0; i--){
    		sb.append(array[i]);
    	}
    	return sb.toString();
    }
    
    @Test
    public void test(){
    	String a = "1010";
    	String b = "1011";
    	System.out.println(addBinary(a,b));
    }
}
