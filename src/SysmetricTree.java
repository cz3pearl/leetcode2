import java.util.LinkedList;


public class SysmetricTree {

	/*
	 * Recursive Version
	public boolean isSymmetric(TreeNode root) {
        if(null != root)
        	return isSymmetric(root.left, root.right);
        else
        	return false;
    }
    
    private boolean isSymmetric(TreeNode p, TreeNode q){
    	return 
    		(null ==p && null == q) 
    	||  (
    			(null != p && null != q)
    		&& 	(p.val == q.val)
    		&&	isSymmetric(p.left, q.right)
    		&&  isSymmetric(p.right, q.left)
    		);
    }
    */
	
    public boolean isSymmetric(TreeNode root) {
        if(null == root)
        	return true;
        LinkedList<TreeNode> leftTreeNodes = new LinkedList<TreeNode>();
        LinkedList<TreeNode> rightTreeNodes = new LinkedList<TreeNode>();
        int idx = 0;
        leftTreeNodes.add(root.left);
        rightTreeNodes.add(root.right);
        while(idx < leftTreeNodes.size()){
        	TreeNode leftNode = leftTreeNodes.get(idx);
        	TreeNode rightNode = rightTreeNodes.get(idx);
        	if(null == leftNode && null == rightNode){
        	} else if (null != leftNode && null != rightNode){
        		if(leftNode.val != rightNode.val)
        			return false;
        		if((null == leftNode.left && null == rightNode.right) ){
        		} else {
        			if(null != leftNode.left && null != rightNode.right){
        				leftTreeNodes.add(leftNode.left);
        				rightTreeNodes.add(rightNode.right);
        			} else {
        				return false;
        			}
        		}
        		
        		if((null == leftNode.right && null == rightNode.left) ){
        		} else {
        			if(null != leftNode.right && null != rightNode.left){
        				leftTreeNodes.add(leftNode.right);
        				rightTreeNodes.add(rightNode.left);
        			} else {
        				return false;
        			}
        		}
        	}
        	idx++;
        }
        
        return true;
    }
    
    public static void main(String args[]){
    	TreeNode root = new TreeNode(1);
    	TreeNode left = new TreeNode(2);
    	root.val = 1;
    	left.val = 2;
    	root.left = left;
    	System.out.println(new SysmetricTree().isSymmetric(root));
    }
}
