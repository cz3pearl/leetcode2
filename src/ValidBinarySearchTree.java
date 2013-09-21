
public class ValidBinarySearchTree {

	private static class MinMax{
		int min;
		int max;
		MinMax(int v){
			this.min = v;
			this.max = v;
		}
		
		MinMax(int min, int max){
			this.min = min;
			this.max = max;
		}
	}
	
    public boolean isValidBST(TreeNode root) {
    	if(null == root)
    		return true;
        MinMax minMax = findMinMax(root);
        if(null != minMax)
        	return true;
        else 
        	return false;
    }
    /*
     * if node is a valid bst
     * 	return minmax
     * else
     *  return null
     */
    private MinMax findMinMax(TreeNode node){
		if(node.left == null && node.right == null){
			return new MinMax(node.val);
		} else if( node.left == null){
			MinMax rightMinMax = findMinMax(node.right);
			if(null == rightMinMax)
				return null;
			if(rightMinMax.min > node.val){
				return new MinMax(node.val, rightMinMax.max);
			} else {
				return null;
			}
		} else if ( node.right == null){
			MinMax leftMinMax = findMinMax(node.left);
			if(null == leftMinMax)
				return null;
			if(leftMinMax.max < node.val){
				return new MinMax(leftMinMax.min, node.val);
			} else {
				return null;
			}
		} else {
			MinMax leftMinMax = findMinMax(node.left);
			MinMax rightMinMax = findMinMax(node.right);
			if( null != leftMinMax && null != rightMinMax){
				if(node.val > leftMinMax.max && node.val < rightMinMax.min){
					return new MinMax(leftMinMax.min, rightMinMax.max);
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
    }
    
    public static void main(String args[]){
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(1);
    	System.out.println(new ValidBinarySearchTree().isValidBST(root));
    }
}
