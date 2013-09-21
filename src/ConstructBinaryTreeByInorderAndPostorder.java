
public class ConstructBinaryTreeByInorderAndPostorder {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val = x;}
	}
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int iLen = inorder.length;
        int pLen = postorder.length;
        return buildTreeNode(inorder, 0, iLen-1, postorder, 0, pLen-1);        
    }
    
    public TreeNode buildTreeNode(int[] inorder, int is, int ie, int[] postorder, int ps, int pe){
    	if(is <= ie && ps <= pe){
    		if(is == ie)
    			return new TreeNode(inorder[is]);
    		int val = postorder[pe];
    		int midIdx = findIdx(val, inorder, is, ie);
    		int len = midIdx - is;
    		TreeNode left = buildTreeNode(inorder, is, midIdx-1, postorder, ps, ps+len-1);
    		TreeNode right = buildTreeNode(inorder, midIdx+1, ie, postorder, ps+len, pe-1);
    		TreeNode parent = new TreeNode(val);
    		parent.left = left;
    		parent.right = right;
    		return parent;
    	} else {
    		return null;
    	}
    }
    
    private int findIdx(int val, int[] array, int as, int ae){
    	int idx = -1;
    	for(int i = as; i<= ae; i++){
    		if(val == array[i]){
    			idx = i;
    		}
    	}
    	return idx;
    }
	
    public static void main(String args[]){
    	int[] inorder = new int[]{2,1,3};
    	int[] postorder = new int[]{1,2,3};
    	TreeNode tree = new ConstructBinaryTreeByInorderAndPostorder().buildTree(inorder, postorder);
    	System.out.println(tree.val);
    }
    
}
