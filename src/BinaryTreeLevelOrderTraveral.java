import java.util.ArrayList;


public class BinaryTreeLevelOrderTraveral {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val = x;}
	}
	
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    	levelTraveral(root, list, 0);
    	return list;
    }
    
    public void levelTraveral(TreeNode node, ArrayList<ArrayList<Integer>>list, int level){
    	if(null != node){
	    	ArrayList<Integer> line = null;
	    	int size = list.size();
	    	if(level < size){
	    		line = list.get(level);
	    	} else {
	    		line = new ArrayList<Integer>();
	    		list.add(line);
	    	}
	    	if(null != node.left)
	    		levelTraveral(node.left, list, level+1);
	    	line.add(node.val);
	    	if(null != node.right)
	    		levelTraveral(node.right, list, level+1);
    	}
    }
	
}
