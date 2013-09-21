
public class PathSum1 {

	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(null == root)
    		return false;
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	if(null == left && null == right){
    		if(sum == root.val)
    			return true;
    		else
    			return false;
    	} else {
    		if(null != left){
    			left.val+=root.val;
    			if(hasPathSum(left, sum)){
    				return true;
    			}
    		}
    		
    		if(null != right){
    			right.val+=root.val;
    			if(hasPathSum(right, sum)){
    				return true;
    			}
    		}
    	}
    	
    	return false;        
    }
	
}
