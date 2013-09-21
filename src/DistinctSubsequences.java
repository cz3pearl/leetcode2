
public class DistinctSubsequences {

	//XXX TODO
    public int numDistinct(String S, String T) {
         int lenS = S.length();
         int lenT = T.length();
         if(lenS < lenT || lenS == 0)
        	 return 0;
         int[][] array = new int[lenS+1][lenT+1];
//         if(S.charAt(lenS -1) == T.charAt(lenT -1))
//        	 array[lenS-1][lenT-1] = 1;
         for(int i = lenS; i >=0;  i--)
        	 array[i][lenT] = 1;
         for(int j = lenT-1; j>=0; j--){
        	 for(int i= lenS-1; i>=0; i--){
        		 if(S.charAt(i) == T.charAt(j))
        			 array[i][j] = array[i+1][j] + array[i+1][j+1];
        		 else
        			 array[i][j] = array[i+1][j];
        	 }
         }
//         printArray(array);
         return array[0][0];
    }
    
    private void printArray(int[][] array){
    	int len0 = array.length;
    	if(len0 > 0){
    		int len1 = array[0].length;
    		for(int i = 0; i < len0; i++){
    			for(int j = 0; j < len1; j++){
    				System.out.print(array[i][j]+",");
    			}
    			System.out.println();
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String args[]){
    	String S = "rabbbit";
    	String T = "rabit";
    	
    	System.out.println(new DistinctSubsequences().numDistinct(S, T));
    }
}
