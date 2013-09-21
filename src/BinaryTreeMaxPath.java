import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class BinaryTreeMaxPath {

	
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val = x;}
	}
	

    public int maxPathSum(TreeNode root) {
		Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        int rootVal = max(root, map);
        int max = rootVal;
        for(Entry<TreeNode, Integer> entry : map.entrySet()){
        	TreeNode node = entry.getKey();
        	int tMax = node.val;
        	if(null != node.left){
        		Integer leftVal = map.get(node.left);
        		if(leftVal > 0)
        			tMax+=leftVal;
        	}
        	if(null != node.right){
        		Integer rightVal = map.get(node.right);
        		if(rightVal > 0)
        			tMax+=rightVal;
        	}
        	if(tMax > max)
        		max = tMax;
        }
        return max;
    }
    
	
	private int max(TreeNode t, Map<TreeNode,Integer> map){
		int max = t.val;
		if (t.left != null){
			Integer leftMax = map.get(t.left);
			if(null == leftMax){
				leftMax = max(t.left, map);
			}
			
			int tMax = leftMax + t.val;
			if(tMax > max){
				max = tMax;
			}
		}
		
		if(t.right != null){
			Integer rightMax = map.get(t.right);
			if(null == rightMax){
				rightMax = max(t.right, map);
			}
			
			int tMax = rightMax + t.val;
			if(tMax > max){
				max = tMax;
			}
		}
		
		map.put(t, max);
		return max;
	}

	
	public static void main(String args[]){
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(-1);
		BinaryTreeMaxPath btmp = new BinaryTreeMaxPath();
		System.out.println(btmp.maxPathSum(root));
	}
	
}
