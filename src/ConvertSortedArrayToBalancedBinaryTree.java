
public class ConvertSortedArrayToBalancedBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public TreeNode sortedArrayToBST(int[] num) {
        int len = num.length;
        return genBinaryTree(num, 0, len-1);
    }
    
    private TreeNode genBinaryTree(int[] num, int start, int end){
    	if(start > end){
    		return null;
    	} else {
    		int mid = (start+end)/2;
    		TreeNode left = genBinaryTree(num, start, mid-1);
    		TreeNode parent = new TreeNode(num[mid]);
    		TreeNode right = genBinaryTree(num, mid+1, end);
    		parent.left = left;
    		parent.right = right;
    		return parent;
    	}
    }
	
}
