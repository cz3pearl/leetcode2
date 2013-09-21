

public class BalancedBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	//return -1 if not balanced binary tree
	private int depth(TreeNode node){
		if(null == node)
			return 0;
		int leftDepth = depth(node.left);
		int rightDepth = depth(node.right);
		if( (leftDepth < 0 || rightDepth < 0) || (Math.abs(leftDepth - rightDepth) > 1))
			return -1;
		else
			return 1+Math.max(leftDepth, rightDepth);
	}
	
    public boolean isBalanced(TreeNode root) {
        if(depth(root) >= 0)
        	return true;
        else
        	return false;
    }
	
}
