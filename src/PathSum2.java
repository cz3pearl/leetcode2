import java.util.ArrayList;


public class PathSum2 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> currStack = new ArrayList<Integer>();
        int leftVal = sum;
        addValidPath(root, leftVal, currStack, list);
        return list;
    }
	
    
    public void addValidPath(TreeNode node, int leftVal, ArrayList<Integer> currStack, ArrayList<ArrayList<Integer>> list){
    	if(null == node)
    		return;
    	TreeNode left = node.left;
    	TreeNode right = node.right;
    	if(null == left && null == right){
    		if(leftVal == node.val){
    			currStack.add(node.val);
    			list.add(currStack);
    		}
    	} else {
    		currStack.add(node.val);
    		int nextLeftVal = leftVal - node.val;
    		
    		if(null != left){
    			ArrayList<Integer> nextLeft = new ArrayList<Integer>();
    			nextLeft.addAll(currStack);
    			addValidPath(left, nextLeftVal, nextLeft, list);
    		}
    		
    		if(null != right){
    			ArrayList<Integer> nextRight = new ArrayList<Integer>();
    			nextRight.addAll(currStack);
    			addValidPath(right, nextLeftVal, nextRight, list);
    		}
    	}
    	
    }
}
