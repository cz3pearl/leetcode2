

public class MinimumDepth {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public int minDepth(TreeNode root) {
    	if(null == root)
    		return 0;
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	if ( null != left && null != right ) {
    		return 1+Math.min(minDepth(left), minDepth(right));
    	} else if ( null == left && null == right ) {
    		return 1;
    	} else if (null != left){
    		return 1+minDepth(left);
    	} else {
    		return 1+minDepth(right);
    	}
    }
	
}
