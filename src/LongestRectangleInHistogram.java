import java.util.Stack;


public class LongestRectangleInHistogram {

//    public int largestRectangleArea(int[] height) {
//        int len = height.length;
//        if(0 == len)
//        	return 0;
//        int max = 0;
//        int lastK = 0;
//        for(int i = 0; i < len; i++){
//        	int k = height[i];
//        	if(k > lastK){
//	        	for(int j = i; j < len; j++){
//	        		if(height[j] > lastK){
//		        		if(k > height[j]){
//		        			k = height[j];
//		        		} 
//		        		max = Math.max(max, k*(j-i+1));
//	        		} else {
//	        			break;
//	        		}
//	        	}
//        	}
//        	lastK = k;
//        }
//        return max;
//    }
    private static int UNSET = -1;
	public int largestRectangleArea(int [] height) {
		Stack<Integer> stack = new Stack<Integer>();
		
		int len = height.length;
		int[] attach = new int[len];
		for(int i = 0; i < len; i++){
			attach[i] = UNSET;
		}
		int i = 0;
		while(i < len){
			if(stack.isEmpty() || height[i] >= height[stack.peek()]){
				stack.push(i);
			} else if ( height[i] < height[stack.peek()] ) {
				while(!stack.isEmpty() && height[i] < height[stack.peek()]){
					int nIdx = stack.pop();
					attach[nIdx] = stack.isEmpty()? i: i - stack.peek() - 1;					
				}
				if(stack.isEmpty() || height[i] >= height[stack.peek()])
					stack.push(i);
			}
			i++;
		}
		
		while(!stack.isEmpty()){
			int nIdx = stack.pop();
			attach[nIdx] = stack.isEmpty()? len: len - 1 - stack.peek(); 
		}
		for(int k : attach){
			System.out.print(k+",");
		}
		System.out.println();
		
		int max = 0;
		for(int j = 0; j < len; j++){
			if(attach[j] != UNSET){
				max = Math.max(max, height[j]*attach[j]);
			}
		}
		return max;
	}
	
    public static void main(String args[]){
    	int[] height = new int[]{4,7,6,8,5,9,1,0};
    	LongestRectangleInHistogram lrih = new LongestRectangleInHistogram();
    	System.out.println(lrih.largestRectangleArea(height));
    }
}
