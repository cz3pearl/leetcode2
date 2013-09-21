import java.util.ArrayList;

import org.junit.Test;


public class GenerateParenthese {
	
    public ArrayList<String> generateParenthesis(int n) {
    	return generatePart("", 0, n,n);
    }

    public ArrayList<String> generatePart(String part, int sum, int posCount, int negCount){
    	ArrayList<String> result = new ArrayList<String>();
    	if(posCount == 0 && negCount == 1){
    		result.add(part+")");
    		return result;
    	}
    	if(posCount > 0){
    		result.addAll(generatePart(part+"(", sum+1, posCount-1, negCount));
    	}
    	if(sum > 0){
    		result.addAll(generatePart(part+")", sum-1, posCount, negCount-1));
    	}
    	return result;
    }
    
    @Test
    public void test(){
    	for(String str: generateParenthesis(3)){
    		System.out.println(str);
    	}
    }
}
