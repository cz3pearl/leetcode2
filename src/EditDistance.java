import org.junit.Test;


public class EditDistance {
    public int minDistance(String word1, String word2) {
    	int len1 = word1.length();
    	int len2 = word2.length();
    	if(len1 == 0)
    		return len2;
    	if(len2 == 0)
    		return len1;
    	
    	int[][] attach = new int[len1][len2];
    	for(int i = 0; i < len1; i++){
    		for(int j = 0; j < len2; j++){
    			attach[i][j] = word1.charAt(i) == word2.charAt(j) ? 0 : 1;
    		}
    	}
    	for(int j = len2-2; j>=0; j--){
    		attach[len1-1][j] +=attach[len1-1][j+1];
    	}
    	for(int i = len1-2; i>=0; i--){
    		attach[i][len2-1] +=attach[i+1][len2-1];
    	}
    	for(int i = len1-2; i >=0; i--){
    		for(int j = len2 -2; j>=0; j--){
    			if(word1.charAt(i) == word2.charAt(j)){
    				attach[i][j] = attach[i+1][j+1];
    			} else {
    				attach[i][j] = Math.min(attach[i+1][j+1]+1,Math.min(attach[i][j+1]+1, attach[i+1][j]));
    			}
    		}
    	}
    	return attach[0][0];
    }
    
    @Test
    public void test(){
    	String word1 = "dist";
    	String word2 = "issu";
//    	"distance", "issuance"
//    	"pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopical"	27	28	
//    	"pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopic"
    	System.out.println(minDistance(word1, word2));
    }
    
    
}
