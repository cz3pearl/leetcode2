import org.junit.Test;


public class TrappingRainWater {
    public int trap(int[] height) {
    	int len = height.length;
    	Stack stack = new Stack(len);
    	int water = 0;
    	for(int i = 0; i < len; i++){
    		if(!stack.isEmpty()){
    			// stack is not Empty
    			if(height[stack.peek()] >= height[i]){
    				stack.push(i);
    			} else {
    				int level = 0;
    				while(!stack.isEmpty() && height[stack.peek()] <= height[i]){
    					int tIdx = stack.pop();
    					water += (i-tIdx-1)*(height[tIdx] - level);
    					level = height[tIdx];
    				}
    				if(!stack.isEmpty()){
    					water += (i - stack.peek() - 1)*(height[i] - level);
    				}
    				
    				stack.push(i);
    			}
    		} else {
    			// stack is Empty
    			stack.push(i);
    		}
    	}
    	
    	return water;
    }
    
    private static class Stack {
    	int[] stack;
    	int topIdx;
    	Stack(int size){
    		stack = new int[size];
    		topIdx = -1;
    	}
    	
    	boolean isEmpty(){
    		return ( topIdx < 0 );
    	}
    	
    	int push(int v){
    		stack[++topIdx] = v;
    		return topIdx;
    	}
    	
    	int pop(){
    		return stack[topIdx--];
    	}
    	
    	int peek(){
    		return stack[topIdx];
    	}
    	
    }
    
    @Test
    public void test(){
    	int[] heights = new int[]{3,2,1,2,3};
    	System.out.println(trap(heights));
    }
}
