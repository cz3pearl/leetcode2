
public class ConstructBinaryTreeByPreorderAndInorder {


	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val = x;}
	}
	
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	int iLen = inorder.length;
        int pLen = preorder.length;
        return buildTreeNode(inorder, 0, iLen-1, preorder, 0, pLen-1);     
    }
	
    public TreeNode buildTreeNode(int[] inorder, int is, int ie, int[] preorder, int ps, int pe){
    	if(is <= ie && ps <= pe){
    		if(is == ie)
    			return new TreeNode(inorder[is]);
    		int val = preorder[ps];
    		int midIdx = findIdx(val, inorder, is, ie);
    		int len = midIdx - is;
    		TreeNode left = buildTreeNode(inorder, is, midIdx-1, preorder, ps+1, ps+len);
    		TreeNode right = buildTreeNode(inorder, midIdx+1, ie, preorder, ps+len+1, pe);
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
    	int[] preorder = new int[]{1,2,3};
    	TreeNode tree = new ConstructBinaryTreeByPreorderAndInorder().buildTree(inorder, preorder);
    	System.out.println(tree.val);
    }
    	
}
