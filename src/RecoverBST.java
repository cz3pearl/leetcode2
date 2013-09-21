
public class RecoverBST {
    public void recoverTree(TreeNode root) {
    	findAndRepairMinMax(root);
    }
    private static final int MIN = 0;
    private static final int MAX = 1;
    private TreeNode[] findAndRepairMinMax(TreeNode node){
    	TreeNode[] minMax = new TreeNode[2];
    	if(null != node){
    		TreeNode[] leftMinMax = findAndRepairMinMax(node.left);
    		TreeNode[] rightMinMax = findAndRepairMinMax(node.right);
    		TreeNode leftMin = leftMinMax[MIN];
    		TreeNode rightMax = rightMinMax[MAX];
    		TreeNode leftMax = leftMinMax[MAX];
    		TreeNode rightMin = rightMinMax[MIN];
    		if(leftMin == null){
    			minMax[0] = node;
    		} else {
    			minMax[0] = leftMin;
    		}
    		if(rightMax == null){
    			minMax[1] = node;
    		} else {
    			minMax[1] = rightMax;
    		}
    		
    		if(null != leftMax && null != rightMin){
    			if(leftMax.val > rightMin.val){
    				doSwap(leftMax, rightMin);
    			} else if ( leftMax.val > node.val){
    				doSwap(leftMax, node);
    			} else if ( rightMin.val < node.val){
    				doSwap(rightMin, node);
    			}
    		} else {
    			if(null != leftMax){
    				if(leftMax.val > node.val){
        				doSwap(leftMax, node);
        			}
    			}
    			
    			if(null != rightMin){
    				if ( rightMin.val < node.val){
        				doSwap(rightMin, node);
        			}
    			}
    		}
    		
    	}
    	return minMax;
    }
    
    private boolean doSwap(TreeNode n1, TreeNode n2){
    	if(null != n1 && null != n2){
    		int t = n1.val;
    		n1.val = n2.val;
        	n2.val = t;
        	return true;
    	} else {
    		return false;
    	}
    }
    
    public static void main(String args[]){
    	For TODO;
    }

}
