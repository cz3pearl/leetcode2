import java.util.HashSet;
import java.util.Stack;

import org.junit.Test;


public class ValidParenthese {

	
    public boolean isValid(String s) {
    	HashSet<Character> openSet = new HashSet<Character>();
    	openSet.add('(');
    	openSet.add('[');
    	openSet.add('{');
    	HashSet<Character> closeSet = new HashSet<Character>();
    	closeSet.add(')');
    	closeSet.add(']');
    	closeSet.add('}');
    	
    	Stack<Character> stack = new Stack<Character>();
    	for(Character c : s.toCharArray()){
    		if(openSet.contains(c)){
    			stack.push(c);
    		} else {
    			Character oc = null;
    			if(!stack.isEmpty())
    				oc = stack.pop();
    			if(null != oc && isPair(oc, c)){
    			} else {
    				return false;
    			}
    		}
    	}
    	if(stack.isEmpty())
    		return true;
    	else
    		return false;
    }
    
    private boolean isPair(Character c1, Character c2){
    	if(
    			(c1 == '(' && c2 == ')') 
    		||	(c1 == '[' && c2 == ']')
    		||	(c1 == '{' && c2 == '}')
    		)
    		return true;
    	else
    		return false;
    }
    
    @Test
    public void test(){
    	System.out.println(isValid("{}[()]"));
    	System.out.println(isValid(")[{"));
    }
}
